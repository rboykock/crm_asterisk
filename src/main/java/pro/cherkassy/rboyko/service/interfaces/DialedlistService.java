package pro.cherkassy.rboyko.service.interfaces;

import pro.cherkassy.rboyko.model.Dial;
import pro.cherkassy.rboyko.model.Dialed;

import java.util.List;

/**
 * Created by rboyko on 11.04.17.
 */
public interface DialedlistService {
    void save(Dialed dialed);
    boolean delete(Dialed dialed);
    boolean delete(int id);
    Dialed findById(int id);
    List<Dialed> getAllDialed();
}
