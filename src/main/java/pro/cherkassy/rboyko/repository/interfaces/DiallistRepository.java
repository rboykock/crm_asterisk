package pro.cherkassy.rboyko.repository.interfaces;

import pro.cherkassy.rboyko.model.Dial;

import java.util.List;

/**
 * Created by rboyko on 17.03.17.
 */
public interface DiallistRepository {
    void save(Dial dial);
    void delete(Dial dial);
    Dial findById(int id);
    List<Dial> getAllDial();
    List<Dial> getDialByCampaignId(int campaignId);
    Dial findByCustomer(int customerId,int campaignId);
}
