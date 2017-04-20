package pro.cherkassy.rboyko.repository;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.cherkassy.rboyko.enums.Status;
import pro.cherkassy.rboyko.model.Campaigns;
import pro.cherkassy.rboyko.repository.interfaces.CampaignsRepository;


import java.util.List;

/**
 * Created by Sergiy on 03.04.2017.
 */

@Repository
public class CampaignsRepositoryImpl implements CampaignsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Campaigns campaigns) {
        sessionFactory.getCurrentSession().save(campaigns);
    }

    @Override
    public void delete(Campaigns campaigns) {
        sessionFactory.getCurrentSession().delete(campaigns);
    }

    @Override
    public void update(Campaigns campaigns) {
        sessionFactory.getCurrentSession().update(campaigns);
    }

    @Override
    public Campaigns findById(int id) {
        return sessionFactory.getCurrentSession().get(Campaigns.class, id);
    }

    @Override
    public boolean contains(Campaigns campaigns) {
        return sessionFactory.getCurrentSession().contains(campaigns);
    }

    @Override
    public List<Campaigns> getAllCampaigns() {
        return sessionFactory.getCurrentSession().createQuery("FROM Campaigns").list();
    }

    @Override
    public void setStatus(int id,Status status){
        Query query=sessionFactory.getCurrentSession().createQuery("update Campaigns set status=:status where id=:id");
        query.setParameter("status",status).setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public Object getTotalExtAndDial(int campaignId) {
        String sql="SELECT (SELECT COUNT(*) FROM users_campaign_assigned WHERE campaign_id=:campaignId) AS extension_total, (SELECT COUNT(*) FROM diallist WHERE campaign_id=:campaignId) as dial_total";
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);

        return (Object)query.setInteger("campaignId",campaignId).uniqueResult();
    }
}
