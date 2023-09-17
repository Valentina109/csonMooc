package com.cspiration.mooc.support;

import com.cspiration.mooc.exception.ConditonException;
import com.cspiration.mooc.utils.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Component
public class UserSupport {
    public Long getCurrentUserId() throws NoSuchAlgorithmException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("token");
        Long userId = TokenUtils.verifyToken(token);
        if (userId<0){
            throw new ConditonException("非法用户");
        }
        return userId;
    }
}
