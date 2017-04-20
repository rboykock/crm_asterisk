package pro.cherkassy.rboyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.cherkassy.rboyko.model.Dial;
import pro.cherkassy.rboyko.repository.interfaces.DiallistRepository;
import pro.cherkassy.rboyko.service.interfaces.DiallistService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by rboyko on 17.03.17.
 */
@Service
@Transactional
public class DiallistServiceImpl implements DiallistService {

    @Autowired
    private DiallistRepository diallistRepository;

    @Override
    public void save(Dial dial) {
        diallistRepository.save(dial);
    }

    @Override
    public boolean delete(Dial dial) {
        diallistRepository.delete(dial);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Dial dial=diallistRepository.findById(id);
        if(dial==null)
            return false;
        diallistRepository.delete(dial);
        return true;
    }


    @Override
    public Dial findById(int id) {
        return diallistRepository.findById(id);
    }

    @Override
    public List<Dial> getAllDial() {
        return diallistRepository.getAllDial();
    }

    @Override
    public List<Dial> getDialByCampaignId(int campaignId) {
        return diallistRepository.getDialByCampaignId(campaignId);
    }

    @Override
    public Dial findByCustomer(int customerId, int campaignId) {
        return diallistRepository.findByCustomer(customerId,campaignId);
    }

}
