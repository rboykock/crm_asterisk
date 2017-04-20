package pro.cherkassy.rboyko.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro.cherkassy.rboyko.model.Customer;
import pro.cherkassy.rboyko.model.Note;
import pro.cherkassy.rboyko.service.NoteServiceImpl;
import pro.cherkassy.rboyko.service.interfaces.CustomerService;
import pro.cherkassy.rboyko.service.interfaces.NoteService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rboyko on 28.11.16.
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity index(@PathVariable long id) {

        return new ResponseEntity(HttpStatus.OK);
    }


}
