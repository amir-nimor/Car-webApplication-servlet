package ir.maktabsharif.controller.filter;

import ir.maktabsharif.model.Request;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.request.RequestRepositoryImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class requestCount implements Filter {

    private RequestRepositoryImpl requestRepository;

    public void init(FilterConfig filterConfig) throws ServletException {
       this.requestRepository =(RequestRepositoryImpl) filterConfig.getServletContext().getAttribute("requestRepository");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        String path = String.valueOf(request.getRequestURL());


        Request request1 = new Request(user,path,session.getId());

        requestRepository.create(request1);

        filterChain.doFilter(request,response);
    }
}
