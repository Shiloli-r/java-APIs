package com.validatepolicy.ValidatePolicy.ipwhitelist;

import com.validatepolicy.ValidatePolicy.log.LoggingFilter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@WebFilter("/*")
public class IPWhitelistFilter implements Filter {

    private final Set<String> allowedIPs = new HashSet<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        // Initialize the allowed IP addresses (whitelist)
        allowedIPs.add("127.0.0.1");
//        allowedIPs.add("0:0:0:0:0:0:0:1");
        // Add more IP addresses as needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String clientIP = request.getRemoteAddr();
        if (allowedIPs.contains(clientIP)) {
            // If the client's IP is in the whitelist, allow the request to proceed
            filterChain.doFilter(request, response);
        } else {
            // If the client's IP is not in the whitelist, deny the request
            response.getWriter().write("Access denied. Your IP address is not whitelisted.");
            LOGGER.info("IP Address: {} Access Denied", request.getRemoteAddr());
        }
    }

    @Override
    public void destroy() {
        // Cleanup resources if needed
    }
}
