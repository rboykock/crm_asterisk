package pro.cherkassy.rboyko.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.repository.interfaces.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by rboyko on 20.03.17.
 */
public interface UserService {
    void save(User user);
    boolean delete(User user);
    boolean delete(int id);
    void update(User user);
    User findById(int id);
    List<User> getAllUsers();
}
