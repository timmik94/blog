package DAO;

import Factory.HibernateUtil;
import Hibernateclasses.Record;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
public class HibernateRecordDao implements RecordDao {
    @Override
    public Record getrecord(long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Record record= (Record) session.get(Record.class,id);
        return record;
    }

    @Override
    public void incertRecord(Record record) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.save(record);
        session.close();
    }

    @Override
    public List<Record> getRecordbyuser(String login) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        List<Record> records=session.createCriteria(Record.class).createAlias("user", "users").
                add(Restrictions.eq("users.login", login)).addOrder(Order.asc("date")).list();
        return records;
    }
}
