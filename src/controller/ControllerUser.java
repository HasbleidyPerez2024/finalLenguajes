package controller;

import Service.CrudUsers;
import Service.CrudUserImpl;

public class ControllerUser {
    private final String versionProtocol = "HTTP/1.1";
    private final String connectionString = "http://localhost:8080/api/users";
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

    public String getUsers() {
        validateConnection();
        userService.findAll();
        return "***********************";
    }

    public String getUsersById(int id) {
        validateConnection();
        userService.findById(id);
        return "**************************";
    }

    public String postUser() {
        validateConnection();
        userService.create(body);
        return "***********************+*";
    }

    public String putUserById(int id) {
        validateConnection();
        userService.updateById(body, id);
        return "*************************";
    }

    public String deleteUserById(int id) {
        validateConnection();
        userService.deleteById(id);
        return "*************************";
    }

    private void validateConnection() {
        if (!url.equals(connectionString)) {
            throw new RuntimeException("No fue posible coneción con la URL " + url);
        }
    }
}
