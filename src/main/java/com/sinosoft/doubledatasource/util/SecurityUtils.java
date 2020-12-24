package com.sinosoft.doubledatasource.util;

import com.sinosoft.ops.archive.common.context.ExecuteContext;
import com.sinosoft.ops.archive.entity.primary.sys.user.Role;
import com.sinosoft.ops.archive.entity.primary.sys.user.User;
import com.sinosoft.ops.archive.entity.primary.sys.user.UserRole;
import com.sinosoft.ops.archive.repository.primary.sys.user.RoleRepository;
import com.sinosoft.ops.archive.util.cache.UserCacheManager;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecurityUtils {
    private static SecurityUtils securityUtil;

    public final static String ACCESS_TOKEN = "accessToken";

    public static SecurityUtils getSubject() {
        if (securityUtil == null) {
            securityUtil = new SecurityUtils();
        }
        return securityUtil;
    }

    /**
     * 当前登录人用户名
     *
     * @return
     */
    public String getCurrentLoginName() {
        if (ExecuteContext.Request.currentRequest() == null) {
            return "";
        }

        String loginName = "";
        String accessToken = ExecuteContext.Request.currentRequest().getHeader(ACCESS_TOKEN);
        if (StringUtils.isEmpty(accessToken)) {
            Cookie cookie = CookieUtils.getCookieByName(ExecuteContext.Request.currentRequest(), ACCESS_TOKEN);
            if (cookie != null) {
                loginName = cookie.getValue();
            }
        } else {
            loginName = accessToken;
        }

        if (StringUtils.isEmpty(loginName)) {
            return "";
        }

        Claims claims = TokenUtils.parseJWT(loginName);

        return claims.getId();
    }

    /**
     * 当前登录人信息
     *
     * @return
     */
    public User getCurrentUser() {
        return UserCacheManager.getUserInfo(getCurrentLoginName());
    }
    /**
     * 当前用户部分权限信息
     *
     * @return
     */
    public Map<String,Object> getCurrentCadre() {
        return UserCacheManager.getCurrentCadre(getCurrentLoginName());
    }

    public List<UserRole> getCurrentUserRole() {
        return UserCacheManager.getUserRole(getCurrentLoginName());
    }

    /**
     * 登陆后调用
     *
     * @return
     */
    public void Login(String loginName) {
        UserCacheManager.clearUser(loginName);
        UserCacheManager.getUserInfo(loginName);
        UserCacheManager.getCurrentCadre(loginName);
        UserCacheManager.getUserRole(loginName);

        String token = TokenUtils.createJwtToken(loginName);
        UserCacheManager.setToken(loginName, token);
        CookieUtils.addCookie(ExecuteContext.Response.currentResponse(), ACCESS_TOKEN, token, 0);
    }

    /**
     * 退出调用
     *
     * @return
     */
    public void LoginOut() {
        UserCacheManager.clearUser(getCurrentLoginName());
        CookieUtils.removeCookie(ExecuteContext.Response.currentResponse(), ACCESS_TOKEN);
    }

    public boolean isAdmin() {
        List<String> roleIds = getCurrentUserRole().stream().map(UserRole::getRoleId).collect(Collectors.toList());
        RoleRepository roleRepository = SpringContextUtils.getBean(RoleRepository.class);
        List<Role> roles = roleRepository.findByIdIn(roleIds);
        for (Role role : roles) {
            if (role.getName().contains("管理员")) {
                return true;
            }
        }

        return false;
    }
    public boolean isAdmin2() {
        List<String> roleIds = getCurrentUserRole().stream().map(UserRole::getRoleId).collect(Collectors.toList());
        RoleRepository roleRepository = SpringContextUtils.getBean(RoleRepository.class);
        List<Role> roles = roleRepository.findByIdIn(roleIds);
        for (Role role : roles) {
            if (role.getName().equals("系统管理员")) {
                return true;
            }
        }

        return false;
    }

    public void refreshToken(String loginName) {
        String token = TokenUtils.createJwtToken(loginName);
        UserCacheManager.setToken(loginName, token);
        CookieUtils.addCookie(ExecuteContext.Response.getCurrent(), ACCESS_TOKEN, token, 0);
    }
}
