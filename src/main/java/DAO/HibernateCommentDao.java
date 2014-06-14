package DAO;

import Factory.HibernateUtil;
import Hibernateclasses.Comment;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
public class HibernateCommentDao implements CommentDao{
    @Override
    public List<Comment> getbyrecord(long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        List<Comment>comments=session.createCriteria(Comment.class).createAlias("record", "Records").
                add(Restrictions.eq("Records.id", id)).addOrder(Order.asc("date")).list();
        session.close();
        return comments;
    }

    @Override
    public void incertcomment(Comment comment) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.save(comment);
        session.close();

    }
}
