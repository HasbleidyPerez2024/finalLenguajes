package Service;

import model.User;

import java.util.List;

public interface CrudUsers {

    void create(String user);
    List<User> readAll();
    void updateById(String updateUser, int id);
    void deleteById(int id);
    void findAll();
    public User findById(int id);

}
