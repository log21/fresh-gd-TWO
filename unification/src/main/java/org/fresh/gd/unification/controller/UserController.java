package org.fresh.gd.unification.controller;


import lombok.extern.slf4j.Slf4j;
import org.fresh.gd.commons.consts.pojo.RequestData;
import org.fresh.gd.commons.consts.pojo.ResponseData;
import org.fresh.gd.commons.consts.pojo.dto.oauth.AuthSysOrganizationDTO;
import org.fresh.gd.commons.consts.pojo.dto.oauth.AuthSysUserDTO;
import org.fresh.gd.commons.consts.pojo.dto.oauth.UserDTO;
import org.fresh.gd.commons.consts.utils.AuthPrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

/**
 * @DATA 2019-04-12 10:01
 * @Author 张国伟  WeChat:17630376104
 * @Description 用户
 */
@Slf4j
@RestController
@RequestMapping("/unification")
public class UserController {

    @RequestMapping("/userinfo")
    public ResponseData<Object> userinfo(Authentication authentication) {
        System.out.println(authentication);
        AuthSysUserDTO authSysUserDTO = AuthPrincipalUtils.parseUserinfo(authentication);
        ResponseData<Object> responseData = new ResponseData<>();
        responseData.setData(authSysUserDTO);
        return responseData;
    }

    @RequestMapping("/pro")
    public ResponseData<Object> pro(Principal authentication) {
        ResponseData<Object> responseData = new ResponseData<>();
        responseData.setData(authentication);
        return responseData;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/sq")
    public String sq() {
        return "sq";
    }

    @RequestMapping("/getPrinciple")
    public Object getPrinciple(OAuth2Authentication oAuth2Authentication,
                               Principal principal, Authentication authentication) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", principal.getName());
        map.put("OAuth2", oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        return map;
    }
}
