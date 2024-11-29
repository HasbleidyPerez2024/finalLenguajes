package controller;

import Service.CrudUserImpl;
import Service.CrudUsers;
import model.User;

import java.util.List;

public class ControllerUser {

    private String url;
    private String headers;
    private String body;
    private int id;
    private CrudUsers userService;

    public ControllerUser(String url, String headers, String body) {
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.userService = new CrudUserImpl();
    }

    public ControllerUser(String url, String headers, String body, int id) {
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.id = id;
        this.userService = new CrudUserImpl();
    }

    public String getUsers(){
        List<User> users = userService.readAll();
        if (users.isEmpty()){
            return "No hay usuarios para mostrar";
        }

        StringBuilder response = new StringBuilder("Lista de usuarios:\n");
        for (User user : users){
            response.append(user.toString()).append("\n");
        }
        return response.toString();
    }

    public String findUserById(int id){
        User user =  userService.findById(id);
        if (user == null){
            return "Usuario no encontrado";
        }
        return user.toString();
    }

    public String postUser(){
        try {
            String[] fields = body.split(",");
            String name = fields[2].trim();
            String email = fields[1].trim();
            int phone = Integer.parseInt(fields[0].trim());

            User newUser = new User(name, email, phone);
            userService.create(newUser);
            return "Usuario creado: " + newUser.toString();
        } catch (Exception e){
            return "Error en creación de usuario: " + e.getMessage();
        }
    }
}
