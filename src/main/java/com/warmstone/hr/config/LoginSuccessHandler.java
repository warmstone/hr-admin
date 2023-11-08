package com.warmstone.hr.config;

import cn.hutool.json.JSONUtil;
import com.warmstone.hr.dto.User;
import com.warmstone.micro.base.common.Result;
import com.warmstone.micro.base.util.JWTUtil;
import com.warmstone.micro.base.util.JsonRenderUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author warmstone
 * @date 2023/11/8 20:24
 * @description
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        User user = (User) authentication.getPrincipal();
        // 生成token
        String token = JWTUtil.generateToken(JSONUtil.toJsonStr(user));
        Result<String> result = Result.ok(token);
        JsonRenderUtil.render(response, JSONUtil.toJsonStr(result));
    }
}
