package ir.maktabsharif.controller.filter;

import ir.maktabsharif.model.Role;
import ir.maktabsharif.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter()
public class AuthorizationFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession(false);

        User user = (User) session.getAttribute("user");


        if (user.getRole().equals(Role.USER)){
            response.sendError(401,"your user dont access");
            return;
        }

        filterChain.doFilter(request,response);


    }
}
