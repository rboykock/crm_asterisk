package pro.cherkassy.rboyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.cherkassy.rboyko.model.Dialed;
import pro.cherkassy.rboyko.repository.interfaces.DialedlistRepository;
import pro.cherkassy.rboyko.service.interfaces.DialedlistService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by rboyko on 11.04.17.
 */
@Service
@Transactional
public class DialedlistServiceImpl implements DialedlistService {
    @Autowired
    private DialedlistRepository dialedlistRepository;

    @Override
    public void save(Dialed dialed) {
        dialedlistRepository.save(dialed);
    }

    @Override
    public boolean delete(Dialed dialed) {
        dialedlistRepository.delete(dialed);
        return  true;
    }

    @Override
    public boolean delete(int id) {
        Dialed dialed=dialedlistRepository.findById(id);
        if(dialed==null)
            return false;
        dialedlistRepository.delete(dialed);
        return true;
    }

    @Override
    public Dialed findById(int id) {
        return dialedlistRepository.findById(id);
    }

    @Override
    public List<Dialed> getAllDialed() {
        return dialedlistRepository.getAllDial();
    }

}
