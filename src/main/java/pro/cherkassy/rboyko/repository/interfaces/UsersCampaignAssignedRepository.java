package pro.cherkassy.rboyko.repository.interfaces;

import pro.cherkassy.rboyko.model.User;

import java.util.List;

/**
 * Created by rboyko on 18.04.17.
 */
public interface UsersCampaignAssignedRepository {
    void save(int idCampaign,String extension);
    List<String> getExtByCampaignId(int id);
    void delete(int campaignId,String extension);
    void deleteAllExtByCampaignId(int campaignId);
    List getUsersAssignedToCampaign(int campaignId);
}
