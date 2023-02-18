package com.example.practice_config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
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
//        ServletResponseWrapper responseWrapper = (ServletResponseWrapper) httpServletResponse;
        httpServletResponse.addHeader("Custom-Header", "This is a custom header");
        httpServletResponse.setContentType("application/json");

        if (browser != null && false && browser.contains("Postman")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            String responseBody = "{ \"message\": \"You're requesting from Postman!\" }";
            httpServletResponse.getWriter().write(responseBody);
            httpServletResponse.getWriter().flush();

            // I need to stop right here before calling to the controller
            // So I dont call filterChain.doFilter()
        } else {
            // This line will get the response
            // If we write the body before this line it will cause the error
            // I think we cannot write to the body 2 times for 1 request
            filterChain.doFilter(servletRequest, servletResponse);

            // One way to modify the body is to use a wrapper
//            String responseBody = "{ \"message\": \"You're requesting from " + browser + "\" }";
//            responseWrapper.getWriter().write(responseBody);
//            responseWrapper.getWriter().flush();
        }

        logger.info("Inside doFilter()");
    }
}
