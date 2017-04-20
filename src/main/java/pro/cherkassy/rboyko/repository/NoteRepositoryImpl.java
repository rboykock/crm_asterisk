package pro.cherkassy.rboyko.repository;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.cherkassy.rboyko.model.Note;
import pro.cherkassy.rboyko.repository.interfaces.NoteRepository;

import java.util.List;

/**
 * Created by rboyko on 16.03.17.
 */
@Repository
public class NoteRepositoryImpl implements NoteRepository {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void save(Note note) {
        sessionFactory.getCurrentSession().save(note);
    }

    @Override
    public void delete(Note note) {
        sessionFactory.getCurrentSession().delete(note);
    }

    @Override
    public void update(Note note) {
        sessionFactory.getCurrentSession().update(note);
    }

    @Override
    public Note findById(int id) {
        return sessionFactory.getCurrentSession().get(Note.class,id);
    }

    @Override
    public List<Note> getAllNotes(int cid) {
        String hql="from Note WHERE customer_id=:cid";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("cid",cid);
        return query.list();
    }

    @Override
    public boolean contains(Note note) {
        if(sessionFactory.getCurrentSession().contains(note))
            return true;
        return false;
    }
}
