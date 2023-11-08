package com.warmstone.hr.config;

import cn.hutool.json.JSONUtil;
import com.warmstone.micro.base.common.Result;
import com.warmstone.micro.base.common.RetCode;
import com.warmstone.micro.base.util.JsonRenderUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author warmstone
 * @date 2023/11/8 21:08
 * @description
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Result<String> result = null;
        if (exception instanceof LockedException) {
            result = Result.fail(RetCode.ACCOUNT_LOCKED.getCode(), RetCode.ACCOUNT_LOCKED.getMessage());
        } else if (exception instanceof AccountExpiredException) {
            result = Result.fail(RetCode.ACCOUNT_EXPIRED.getCode(), RetCode.ACCOUNT_EXPIRED.getMessage());
        } else if (exception instanceof DisabledException) {
            result = Result.fail(RetCode.ACCOUNT_DISABLED.getCode(), RetCode.ACCOUNT_DISABLED.getMessage());
        } else if (exception instanceof BadCredentialsException) {
            result = Result.fail(RetCode.ACCOUNT_PASSWORD_ERROR.getCode(), RetCode.ACCOUNT_PASSWORD_ERROR.getMessage());
        }
        JsonRenderUtil.render(response, JSONUtil.toJsonStr(result));
    }
}
