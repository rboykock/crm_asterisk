package pro.cherkassy.rboyko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.service.UserServiceImpl;
import pro.cherkassy.rboyko.service.interfaces.UserService;

import java.util.List;

/**
 * Created by rboyko on 20.03.17.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List> index(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<List>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        User user=userService.findById(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(userService.delete(id))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody User user){
        userService.update(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
