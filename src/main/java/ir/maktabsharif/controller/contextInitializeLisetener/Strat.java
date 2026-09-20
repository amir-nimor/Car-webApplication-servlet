package ir.maktabsharif.controller.contextInitializeLisetener;

import ir.maktabsharif.model.Car;
import ir.maktabsharif.model.Role;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.car.CarRepositoryImpl;
import ir.maktabsharif.repository.request.RequestRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Strat implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        CarRepositoryImpl carRepository = new CarRepositoryImpl();
        RequestRepositoryImpl requestRepository = new RequestRepositoryImpl();


        User user1 = new User("amir","05615411","username1","password1");
        User user2 = new User("ali","75637532","username2","password2");
        User user3 = new User("reza","7863743","username3","password3");
        User user4 = new User("hosein","8973753","username4","password4");
        user1.setRole(Role.USER);
        user2.setRole(Role.USER);
        user3.setRole(Role.USER);
        user4.setRole(Role.USER);


        userRepository.create(user1);
        userRepository.create(user2);
        userRepository.create(user3);
        userRepository.create(user4);



        Car car1 = new Car("Toyota Camry", "2024", "Silver", 2500);
        Car car2 = new Car("BMW M5", "2023", "Matte Black", 4400);
        Car car3 = new Car("Ford Mustang", "1967", "Cherry Red", 5000);
        Car car4 = new Car("Tesla Model 3", "2025", "Pearl White", 2500);
        Car car5 = new Car("Mercedes-Benz S-Class", "2024", "Obsidian Black", 3000);
        Car car6 = new Car("Honda Civic", "2022", "Modern Steel", 1800);
        Car car7 = new Car("Porsche 911", "2024", "Racing Yellow", 3800);
        Car car8 = new Car("Audi A4", "2023", "Daytona Gray", 2000);
        Car car9 = new Car("Nissan GT-R", "2024", "Ultimate Silver", 3800);
        Car car10 = new Car("Volkswagen Golf", "2021", "Deep Blue", 1400);

        carRepository.create(car1);
        carRepository.create(car2);
        carRepository.create(car3);
        carRepository.create(car4);
        carRepository.create(car5);
        carRepository.create(car6);
        carRepository.create(car7);
        carRepository.create(car8);
        carRepository.create(car9);
        carRepository.create(car10);


        sce.getServletContext().setAttribute("userRepository",userRepository);
        sce.getServletContext().setAttribute("carRepository",carRepository);
        sce.getServletContext().setAttribute("requestRepository",requestRepository);
    }
}
