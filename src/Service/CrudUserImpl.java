package Service;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class CrudUserImpl implements CrudUsers {
    private static List<User> users = new ArrayList<>(); // Lista estática
    private User user;

    @Override
    public void create(String body) {
        String[] fields = body.split(",");
        String names = fields[0].trim();
        String email = fields[1].trim();
        int phone = Integer.parseInt(fields[2].trim());
        User user = new User(names, email, phone);
        users.add(user);
        System.out.println("usuario creado");
        printUsers(users);

    }

    @Override
    public List<User> readAll() {
        return users;
    }

    @Override
    public void updateById(String body, int id) {
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (user != null) {
            String[] fields = body.split(",");
            user.setName(fields[0].trim());
            user.setEmail(fields[1].trim());
            user.setPhone(Integer.parseInt(fields[2].trim()));
            System.out.println("Usuario actualizado" + user);
        } else {
            System.out.println("Usuario con id: " + id + "No encontrado");
        }
    }

    @Override
    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
        System.out.println("Usuario con id: " + id + " eliminado");
    }

    @Override
    public void findAll() {
        printUsers(users);
    }

    @Override
    public User findById(int id) {
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Usuario con id:" + id + "No encontrado");
        }
        return user;
    }

    public void printUsers(List<User> users) {
        System.out.println("Lista de usuarios:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
