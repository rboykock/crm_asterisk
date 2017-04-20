package pro.cherkassy.rboyko.wrappers;

import pro.cherkassy.rboyko.model.Campaigns;

import java.util.List;

/**
 * Created by rboyko on 18.04.17.
 */
public class CampaingWrapper {
    protected Campaigns campaigns;
    protected List<String> extensions;

    public CampaingWrapper() {
    }

    public CampaingWrapper(Campaigns campaigns, List<String> extensions) {
        this.campaigns = campaigns;
        this.extensions = extensions;
    }

    public Campaigns getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(Campaigns campaigns) {
        this.campaigns = campaigns;
    }

    public List<String> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<String> extensions) {
        this.extensions = extensions;
    }
}
