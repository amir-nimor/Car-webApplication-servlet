package ir.maktabsharif.controller;

import ir.maktabsharif.repository.user.UserRepositoryImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "logout",value = "/logout")
public class logoutServlet extends HttpServlet {
    private UserRepositoryImpl userRepository;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userRepository = (UserRepositoryImpl) getServletContext().getAttribute("userRepository");
    }



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session==null){
            resp.sendError(404,"you not logging");
            return;
        }

        Integer id = (Integer) session.getAttribute("id");

        session.invalidate();

        Cookie[] cookies = req.getCookies();

        for (Cookie c : cookies){
            c.setValue("");
            c.setMaxAge(0);
            resp.addCookie(c);
        }

        userRepository.delete(id);

        req.getRequestDispatcher("page/logoutsucsses.jsp").forward(req,resp);
    }
}
