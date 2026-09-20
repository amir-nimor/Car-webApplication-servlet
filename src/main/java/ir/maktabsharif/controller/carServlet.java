package ir.maktabsharif.controller;

import ir.maktabsharif.model.Car;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.car.CarRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "car",value = "/car")
public class carServlet extends HttpServlet {
    private CarRepositoryImpl carRepository;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.carRepository = (CarRepositoryImpl) getServletContext().getAttribute("carRepository");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carRepository.findAll();
        req.setAttribute("car",cars);
        req.getRequestDispatcher("page/car.jsp").forward(req,resp);
    }
}
