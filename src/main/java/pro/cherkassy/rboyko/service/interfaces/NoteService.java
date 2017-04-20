package pro.cherkassy.rboyko.service.interfaces;

import pro.cherkassy.rboyko.model.Note;

import java.util.List;

/**
 * Created by rboyko on 16.03.17.
 */
public interface NoteService {
    void save(Note note);
    boolean delete(Note note);
    boolean delete(int id);
    void update(Note note);
    Note findById(int id);
    List<Note> getAllNotes(int cid);
}
