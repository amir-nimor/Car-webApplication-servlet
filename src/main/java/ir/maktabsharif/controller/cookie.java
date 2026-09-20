package ir.maktabsharif.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookie",value = "/cookie")
public class cookie extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();

        out.println("<ul>");

        for (Cookie c : cookies){
            out.println("<li>");
            out.println(c.getName()+"   "+c.getValue());
            out.println("</li>");
        }

        out.println("</ul>");
    }
}
