package pro.cherkassy.rboyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.repository.interfaces.UsersCampaignAssignedRepository;
import pro.cherkassy.rboyko.service.interfaces.UsersCampaignAssignedService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by rboyko on 18.04.17.
 */
@Service
@Transactional
public class UsersCampaignAssignedServiceImpl implements UsersCampaignAssignedService{

    @Autowired
    private UsersCampaignAssignedRepository usersCampaignAssignedRepository;

    @Override
    public void save(int idCampaign, String extension) {
        usersCampaignAssignedRepository.save(idCampaign,extension);
    }

    @Override
    public List getExtByCampaignId(int id) {
        return usersCampaignAssignedRepository.getExtByCampaignId(id);
    }

    @Override
    public void delete(int campaignId, String extension) {
        usersCampaignAssignedRepository.delete(campaignId,extension);
    }

    @Override
    public void deleteAllExtensionsByCampaignId(int campaignId) {
        usersCampaignAssignedRepository.deleteAllExtByCampaignId(campaignId);
    }

    @Override
    public List getUsersAssignedToCampaign(int campaignId) {
        return usersCampaignAssignedRepository.getUsersAssignedToCampaign(campaignId);
    }
}
