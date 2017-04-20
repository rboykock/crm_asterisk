package pro.cherkassy.rboyko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.cherkassy.rboyko.model.Note;
import pro.cherkassy.rboyko.service.interfaces.NoteService;

import java.util.Date;
import java.util.List;

/**
 * Created by rboyko on 30.03.17.
 */
@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping(value = "/customer/{cid}")
    public ResponseEntity<List> getAllNote(@PathVariable int cid){
        List<Note> notes=noteService.getAllNotes(cid);
        return new ResponseEntity<List>(notes, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id){
        return new ResponseEntity<Note>(noteService.findById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/customer/{cid}")
    public ResponseEntity add(@RequestBody Note note,@PathVariable int cid){
        note.setCustomerId(cid);
        note.setDate(new Date().getTime());
        noteService.save(note);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Note note){
        noteService.update(note);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(noteService.delete(id))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
