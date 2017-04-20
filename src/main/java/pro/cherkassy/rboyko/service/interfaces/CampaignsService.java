package pro.cherkassy.rboyko.service.interfaces;

import pro.cherkassy.rboyko.enums.Status;
import pro.cherkassy.rboyko.model.Campaigns;
import pro.cherkassy.rboyko.model.User;

import java.util.List;

/**
 * Created by Sergiy on 03.04.2017.
 */
public interface CampaignsService {
    void save(Campaigns campaigns,List<String> extensions);
    boolean delete(Campaigns campaigns);
    boolean delete(int id);
    void update(Campaigns campaigns, List<String> extensions);
    Campaigns findById(int id);
    List<Campaigns> getAllCampaigns();
    void setStatus(int id,Status status);
    List<String> getExtensions(Campaigns campaigns);
    List getAssignedUsersToCampaign(int campaignId);
    void deleteExtension(int campaignId,String extention);
    Object getTotalExtAndDial(int campaignId);
}
