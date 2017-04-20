package pro.cherkassy.rboyko.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.cherkassy.rboyko.model.Dial;
import pro.cherkassy.rboyko.service.DiallistServiceImpl;
import pro.cherkassy.rboyko.service.interfaces.DiallistService;

import java.util.List;

/**
 * Created by rboyko on 17.03.17.
 */
@RestController
@RequestMapping(value = "/diallist")
public class DiallistController {

    @Autowired
    protected DiallistService diallistService;

    @GetMapping
    public ResponseEntity<List> index(){
        List<Dial> dialList=diallistService.getAllDial();
        return new ResponseEntity<List>(dialList,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(diallistService.delete(id))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
