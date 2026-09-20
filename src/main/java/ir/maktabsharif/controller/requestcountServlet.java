package ir.maktabsharif.controller;

import ir.maktabsharif.model.Request;
import ir.maktabsharif.repository.request.RequestRepositoryImpl;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "count",value = "/count")
public class requestcountServlet extends HttpServlet {
    private RequestRepositoryImpl requestRepository;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.requestRepository = (RequestRepositoryImpl) getServletContext().getAttribute("requestRepository");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);

        if (session==null){
            resp.sendError(404,"session not founded");
            return;
        }


        List<Request> requests = requestRepository.findAll();

        int id =(Integer) session.getAttribute("id");

        int count = requests.parallelStream().filter(r -> r.getId() == id).toList().size();

        out.println(count);
    }

}
