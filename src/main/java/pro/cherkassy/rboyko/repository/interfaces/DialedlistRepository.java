package pro.cherkassy.rboyko.repository.interfaces;

import pro.cherkassy.rboyko.model.Dialed;

import java.util.List;

/**
 * Created by rboyko on 11.04.17.
 */
public interface DialedlistRepository {
    void save(Dialed dial);
    void delete(Dialed dial);
    Dialed findById(int id);
    List<Dialed> getAllDial();
}
