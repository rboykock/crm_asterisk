package pro.cherkassy.rboyko.repository;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.cherkassy.rboyko.model.Dial;
import pro.cherkassy.rboyko.repository.interfaces.DiallistRepository;

import java.util.List;

/**
 * Created by rboyko on 17.03.17.
 */
@Repository
public class DiallistRepositoryImpl implements DiallistRepository {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void save(Dial dial) {
        sessionFactory.getCurrentSession().save(dial);
    }

    @Override
    public void delete(Dial dial) {
        sessionFactory.getCurrentSession().delete(dial);
    }

    @Override
    public Dial findById(int id) {
        return sessionFactory.getCurrentSession().get(Dial.class,id);
    }

    @Override
    public List<Dial> getAllDial() {
        return sessionFactory.getCurrentSession().createQuery("from Dial").list();
    }

    @Override
    public List<Dial> getDialByCampaignId(int campaignId) {
        String hql="from Dial where campaign_id=:campaignId";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        return  query.setParameter("campaignId",campaignId).list();
    }

    @Override
    public Dial findByCustomer(int customerId, int campaignId) {
        String hsql="from Dial where campaign_id=:campaignId and customer_id=:customerId";
        Query query=sessionFactory.getCurrentSession().createQuery(hsql);
        return (Dial)query.setInteger("customerId",customerId).setInteger("campaignId",campaignId).uniqueResult();
    }

}
