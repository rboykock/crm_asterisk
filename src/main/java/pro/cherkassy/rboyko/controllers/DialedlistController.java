package pro.cherkassy.rboyko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.cherkassy.rboyko.model.Dialed;
import pro.cherkassy.rboyko.service.interfaces.DialedlistService;

import java.util.List;

/**
 * Created by rboyko on 11.04.17.
 */
@RestController
@RequestMapping(value = "/dialedlist")
public class DialedlistController {

    @Autowired
    DialedlistService dialedlistService;

    @GetMapping
    public ResponseEntity<List> index(){
        List<Dialed> dialedList=dialedlistService.getAllDialed();
        return new ResponseEntity(dialedList, HttpStatus.OK);
    }
}
