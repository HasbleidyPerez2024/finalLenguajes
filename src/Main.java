import controller.ControllerUser;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ControllerUser controllerUser = new ControllerUser("http://localhost:8080/api/users", "Content-Type: application/json", "Hasbleidy, hpg@gmail.com, 3226080656");

        System.out.println(controllerUser.postUser());

        new ControllerUser("http://localhost:8080/api/users", "Content-Type: application/json", "Hasbleidy, hpg@gmail.com, 3226080656");
        System.out.println(controllerUser.postUser());

        System.out.println(controllerUser.getUsers());

        System.out.println(controllerUser.findUserById(1));

    }
}