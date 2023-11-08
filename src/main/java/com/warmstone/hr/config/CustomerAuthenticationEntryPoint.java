package com.warmstone.hr.config;

import cn.hutool.json.JSONUtil;
import com.warmstone.micro.base.common.Result;
import com.warmstone.micro.base.common.RetCode;
import com.warmstone.micro.base.util.JsonRenderUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author warmstone
 * @date 2023/11/8 22:03
 * @description 未登录时访问接口
 */
@Component
public class CustomerAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result<Object> result = Result.fail(RetCode.UNAUTHORIZED.getCode(), RetCode.UNAUTHORIZED.getMessage());
        JsonRenderUtil.render(response, JSONUtil.toJsonStr(result));
    }
}
