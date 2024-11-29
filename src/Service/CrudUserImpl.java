package Service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class CrudUserImpl implements CrudUsers {

    private List<User> users;

    public CrudUserImpl(){
        this.users = new ArrayList<>();
    }

    @Override
    public void create(User user) {
        users.add(user);

    }

    @Override
    public List<User> readAll() {
        return List.of();
    }

    @Override
    public void updateById(User updateUser, int id) {
        User existingUser = findById(id);

        if (existingUser != null){
            users.remove(existingUser);
            users.add(updateUser);
        }
    }

    @Override
    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public void findAll() {

    }

    @Override
    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
