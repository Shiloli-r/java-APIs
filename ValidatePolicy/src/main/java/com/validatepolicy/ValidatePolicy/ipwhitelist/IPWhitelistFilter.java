package com.validatepolicy.ValidatePolicy.ipwhitelist;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@WebFilter("/*")
public class IPWhitelistFilter implements Filter {

    private final Set<String> allowedIPs = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) {
        // Initialize the allowed IP addresses (whitelist)
        allowedIPs.add("127.0.0.1");
        // Add more IP addresses as needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String clientIP = request.getRemoteAddr();
        if (allowedIPs.contains(clientIP)) {
            // If the client's IP is in the whitelist, allow the request to proceed
            chain.doFilter(request, response);
        } else {
            // If the client's IP is not in the whitelist, deny the request
            response.getWriter().write("Access denied. Your IP address is not whitelisted.");
            System.out.print("--------------------- IP address {} NOT Allowed ---------------------------------");
            System.out.print(clientIP);
        }
    }

    @Override
    public void destroy() {
        // Cleanup resources if needed
    }
}
