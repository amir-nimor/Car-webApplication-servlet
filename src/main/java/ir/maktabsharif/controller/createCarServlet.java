package ir.maktabsharif.controller;

import ir.maktabsharif.model.Car;
import ir.maktabsharif.model.Role;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.car.CarRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "createcar",value = "/createCar")
public class createCarServlet extends HttpServlet {

    private CarRepositoryImpl carRepository;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.carRepository = (CarRepositoryImpl) getServletContext().getAttribute("carRepository");
    }



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("page/createCar.jsp").forward(req,resp);
    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String carmodel =  req.getParameter("carmodel");
        String caryear =  req.getParameter("caryear");
        String carcolor =  req.getParameter("carcolor");
        Integer carengine = Integer.valueOf(req.getParameter("carengine"));

        Car car = new Car(carmodel,caryear,carcolor,carengine);

        carRepository.create(car);

        req.getRequestDispatcher("./index.jsp").forward(req,resp);


    }

}

