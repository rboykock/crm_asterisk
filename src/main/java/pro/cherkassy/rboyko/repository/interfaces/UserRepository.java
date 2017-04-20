package pro.cherkassy.rboyko.repository.interfaces;

import pro.cherkassy.rboyko.model.User;

import java.util.List;

/**
 * Created by rboyko on 20.03.17.
 */
public interface UserRepository {
    void save(User user);
    void delete(User user);
    void update(User user);
    User findById(int id);
    List<User> getAllUsers();
    boolean contains(User user);
}
