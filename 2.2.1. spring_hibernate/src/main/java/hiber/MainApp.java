package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setUserCar(new Car("SomeModel1", 12546));
        userService.add(user1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        userService.add(user2);

        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setUserCar(new Car("SomeModel2", 26598));
        userService.add(user3);

        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        user4.setUserCar(new Car("SomeModel3", 84591));
        userService.add(user4);

        User user5 = new User("User5", "Lastname5", "user5@mail.ru");
        userService.add(user5);

        User user6 = new User("User6", "Lastname6", "user6@mail.ru");
        user6.setUserCar(new Car("SomeModel4", 464859));
        userService.add(user6);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println(user.getUserCar());
        }

        Car carForFindingUser = new Car("SomeModel3", 84591);

        System.out.println(userService.findUserByCar(carForFindingUser));

        context.close();
    }
}
