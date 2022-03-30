package com.morj.visitscount.filter;

import com.morj.visitscount.redis.RedisClient;
import com.morj.visitscount.time.Clockwork;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
@RequiredArgsConstructor
public class VisitsFilter implements Filter {

    private final RedisClient redisClient;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String remoteAddr = servletRequest.getRemoteAddr();
        String method = request.getMethod();
        redisClient.increment(remoteAddr);
        redisClient.increment(method);
        redisClient.increment(request.getHeader("User-Agent"));

        if (!"/time".equals(request.getServletPath()) || !method.equals("GET")) {
            String timeFormat = Clockwork.getTime();
            redisClient.set("time_" + remoteAddr, timeFormat);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
