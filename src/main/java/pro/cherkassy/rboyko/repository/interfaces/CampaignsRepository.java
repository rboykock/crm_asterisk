package pro.cherkassy.rboyko.repository.interfaces;

import pro.cherkassy.rboyko.enums.Status;
import pro.cherkassy.rboyko.model.Campaigns;
import pro.cherkassy.rboyko.model.User;

import java.util.List;

/**
 * Created by Sergiy on 03.04.2017.
 */
public interface CampaignsRepository {
    void save(Campaigns campaigns);
    void delete(Campaigns campaigns);
    void update(Campaigns campaigns);
    Campaigns findById(int id);
    boolean contains(Campaigns campaigns);
    List<Campaigns> getAllCampaigns();
    void setStatus(int id,Status status);
    Object getTotalExtAndDial(int campaignId);
}
