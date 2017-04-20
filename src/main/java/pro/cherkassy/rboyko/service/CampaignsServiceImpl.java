package pro.cherkassy.rboyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.cherkassy.rboyko.enums.Status;
import pro.cherkassy.rboyko.model.Campaigns;
import pro.cherkassy.rboyko.repository.interfaces.CampaignsRepository;
import pro.cherkassy.rboyko.service.interfaces.CampaignsService;
import pro.cherkassy.rboyko.service.interfaces.UsersCampaignAssignedService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sergiy on 03.04.2017.
 */

@Service
@Transactional
public class CampaignsServiceImpl implements CampaignsService {

    @Autowired
    CampaignsRepository campaignsRepository;

    @Autowired
    protected UsersCampaignAssignedService usersCampaignAssignedService;

    @Override
    public void save(Campaigns campaigns, List<String> extensions) {
        campaignsRepository.save(campaigns);
        for(String ext:extensions){
            usersCampaignAssignedService.save(campaigns.getId(),ext);
        }
    }

    @Override
    public boolean delete(Campaigns campaigns) {
        if(campaignsRepository.contains(campaigns)){
            campaignsRepository.delete(campaigns);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Campaigns campaigns = campaignsRepository.findById(id);
        if(campaigns == null){
            return false;
        }
        campaignsRepository.delete(campaigns);
        usersCampaignAssignedService.deleteAllExtensionsByCampaignId(campaigns.getId());
        return true;
    }

    @Override
    public void update(Campaigns campaigns,List<String> extensions) {
        campaignsRepository.update(campaigns);
        usersCampaignAssignedService.deleteAllExtensionsByCampaignId(campaigns.getId());
        for(String extension:extensions) {
            usersCampaignAssignedService.save(campaigns.getId(),extension);
        }
    }

    @Override
    public Campaigns findById(int id) {
        return campaignsRepository.findById(id);
    }

    @Override
    public List<Campaigns> getAllCampaigns() {
        return campaignsRepository.getAllCampaigns();
    }

    @Override
    public void setStatus(int id,Status status){
        campaignsRepository.setStatus(id,status);
    }

    @Override
    public List<String> getExtensions(Campaigns campaigns) {
        return usersCampaignAssignedService.getExtByCampaignId(campaigns.getId());
    }

    @Override
    public List getAssignedUsersToCampaign(int campaignId) {
        return usersCampaignAssignedService.getUsersAssignedToCampaign(campaignId);
    }

    @Override
    public void deleteExtension(int campaignId, String extention) {
        usersCampaignAssignedService.delete(campaignId,extention);
    }

    @Override
    public Object getTotalExtAndDial(int campaignId) {
        return campaignsRepository.getTotalExtAndDial(campaignId);
    }


}
