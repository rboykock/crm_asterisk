package pro.cherkassy.rboyko.service.interfaces;

import pro.cherkassy.rboyko.model.User;

import java.util.List;

/**
 * Created by rboyko on 18.04.17.
 */
public interface UsersCampaignAssignedService {
    void save(int idCampaign,String extension);
    List getExtByCampaignId(int id);
    void delete(int campaignId,String extension);
    void deleteAllExtensionsByCampaignId(int campaignId);
    List getUsersAssignedToCampaign(int campaignId);
}
