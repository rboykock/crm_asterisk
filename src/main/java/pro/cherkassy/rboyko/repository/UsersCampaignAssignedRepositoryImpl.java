package pro.cherkassy.rboyko.repository;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.repository.interfaces.UsersCampaignAssignedRepository;

import java.util.List;

/**
 * Created by rboyko on 18.04.17.
 */
@Repository
public class UsersCampaignAssignedRepositoryImpl implements UsersCampaignAssignedRepository {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void save(int idCampaign, String extension) {
        String sql="INSERT INTO users_campaign_assigned  (user_extension,campaign_id) VALUE (:extension,:idCampaign)";
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.setParameter("extension", extension).setParameter("idCampaign", idCampaign).executeUpdate();
    }

    @Override
    public List<String> getExtByCampaignId(int id) {
        String sql="SELECT user_extension FROM users_campaign_assigned WHERE campaign_id=:id";
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
        return query.setParameter("id",id).list();
    }

    @Override
    public void delete(int campaignId, String extension) {
        String sql="DELETE FROM users_campaign_assigned WHERE user_extension=:extension AND campaign_id=:campaignId";
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.setInteger("campaignId",campaignId).setString("extension",extension).executeUpdate();
    }

    @Override
    public void deleteAllExtByCampaignId(int campaignId) {
        String sql="DELETE FROM users_campaign_assigned WHERE campaign_id=:campaignId";
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.setInteger("campaignId", campaignId).executeUpdate();
    }

    @Override
    public List getUsersAssignedToCampaign(int campaignId) {
        String sql="SELECT users.id,users.extension,users.login,users.email FROM users LEFT JOIN users_campaign_assigned ON users.extension=users_campaign_assigned.user_extension WHERE users_campaign_assigned.campaign_id=:campaignId";
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
        return query.setInteger("campaignId",campaignId).list();
    }


}
