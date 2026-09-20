package ir.maktabsharif.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter("/cookie")
public class CookieFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Cookie[] cookies = request.getCookies();

        String Token = null;

        for (Cookie c : cookies){
            if ("token".equals(c.getName())){
                Token = c.getValue();
            }
        }

        if (!Token.isBlank()){
            filterChain.doFilter(request,response);
            return;
        }
        response.sendError(401,"you done have username");

    }
}
