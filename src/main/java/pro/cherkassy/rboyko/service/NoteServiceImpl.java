package pro.cherkassy.rboyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.cherkassy.rboyko.model.Note;
import pro.cherkassy.rboyko.repository.interfaces.NoteRepository;
import pro.cherkassy.rboyko.service.interfaces.NoteService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by rboyko on 16.03.17.
 */
@Service
@Transactional
public class NoteServiceImpl implements NoteService{

    @Autowired
    protected NoteRepository noteRepository;

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public boolean delete(Note note) {
        if(noteRepository.contains(note)) {
            noteRepository.delete(note);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Note note=noteRepository.findById(id);
        if(note == null)
            return false;
        noteRepository.delete(note);
        return true;
    }


    @Override
    public void update(Note note) {
        noteRepository.update(note);
    }

    @Override
    public Note findById(int id) {
        return noteRepository.findById(id);
    }

    @Override
    public List<Note> getAllNotes(int cid) {
        return noteRepository.getAllNotes(cid);
    }

}
