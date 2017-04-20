package pro.cherkassy.rboyko.repository.interfaces;

import pro.cherkassy.rboyko.model.Note;

import java.util.List;

/**
 * Created by rboyko on 16.03.17.
 */
public interface NoteRepository {
    void save(Note note);
    void delete(Note note);
    void update(Note note);
    Note findById(int id);
    List<Note> getAllNotes(int cid);
    boolean contains(Note note);
}
