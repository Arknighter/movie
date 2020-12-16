package com.yjh.movie.utils;

import com.yjh.movie.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        //URL：除了登录请求外，其他的url都进行拦截控制
        if(url.indexOf("/welcome/login")>=0) {
            return true;
        }
        //获取session
        HttpSession session = request.getSession();
        User users = (User) session.getAttribute("users");
        //判断Seesion有没有值
        if(users!=null) {
            return true;
        }

        request.getRequestDispatcher("/welcome/login").forward(request, response);
        return false;
    }

}
