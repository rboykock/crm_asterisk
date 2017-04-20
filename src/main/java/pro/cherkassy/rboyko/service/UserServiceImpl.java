package pro.cherkassy.rboyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.repository.interfaces.UserRepository;
import pro.cherkassy.rboyko.service.interfaces.UserService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by rboyko on 20.03.17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean delete(User user) {
        if (userRepository.contains(user)){
            userRepository.delete(user);
            return true;
        }
            return false;
    }

    @Override
    public boolean delete(int id) {
        User user=userRepository.findById(id);
        if(user ==null)
            return false;
        userRepository.delete(user);
        return true;
    }


    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public User findById(int id) {
       return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
