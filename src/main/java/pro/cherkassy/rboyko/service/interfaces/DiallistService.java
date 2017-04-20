package pro.cherkassy.rboyko.service.interfaces;

import pro.cherkassy.rboyko.model.Dial;

import java.util.List;

/**
 * Created by rboyko on 17.03.17.
 */
public interface DiallistService {
    void save(Dial dial);
    boolean delete(Dial dial);
    boolean delete(int id);
    Dial findById(int id);
    List<Dial> getAllDial();
    List<Dial> getDialByCampaignId(int campaignId);
    Dial findByCustomer(int customerId, int campaignId);
}
