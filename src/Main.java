import controller.ControllerUser;

public class Main {
    public static void main(String[] args) {
        // Crear un usuario
        ControllerUser controller = new ControllerUser("http://localhost:8080/api/users", "Content-Type: application/json", "Sebastian,sebas@gmail.com,123456789");
        System.out.println(controller.postUser());

        // Crear otro usuario
        controller = new ControllerUser("http://localhost:8080/api/users", "Content-Type: application/json", "Hasbleidy,hasbleidy@gmail.com,41654646");
        System.out.println(controller.postUser());

        // Crear otro usuario
        controller = new ControllerUser("http://localhost:8080/api/users", "Content-Type: application/json", "Natalia,nati@gmail.com,5454655");
        System.out.println(controller.postUser());

        // Obtener todos los usuarios
        System.out.println("obtener todos los usuarios:");
        System.out.println(controller.getUsers());

        // Obtener un usuario por ID
        System.out.println("obtener usuario por id");
        System.out.println(controller.getUsersById(1));

        // Actualizar un usuario por ID
        System.out.println("Actualizar usuario por ID");
        controller = new ControllerUser("http://localhost:8080/api/users", "Content-Type: application/json", "Andres gonzales,Andres@gmail.com,1122334455", 2);
        System.out.println(controller.putUserById(2));

        // Eliminar un usuario por ID
        System.out.println("Eliminar usuario por ID");
        System.out.println(controller.deleteUserById(1));

        // Mostrar todos los usuarios después de eliminar
        System.out.println(controller.getUsers());


    }
}
