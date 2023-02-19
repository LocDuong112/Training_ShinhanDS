package com.example.practice_config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
public class BrowserDetectorFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(BrowserDetectorFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String browser = httpServletRequest.getHeader("User-Agent");

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.addHeader("Custom-Header", "This is a custom header");
        httpServletResponse.setContentType("application/json");

        if (browser != null && browser.contains("Postman")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            String responseBody = "{ \"message\": \"You're requesting from Postman!\" }";
            httpServletResponse.getWriter().write(responseBody);
            httpServletResponse.getWriter().flush();
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        logger.info("Inside doFilter()");
    }
}
