package Factory;

import DAO.CommentDao;
import DAO.RecordDao;
import DAO.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by timur on 14.06.2014.
 */
public class DaoFactory {
    public UserDao getUserDao(){
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) beanFactory.getBean("userDao");
        return userDao;

    }
    public RecordDao getRecordDao(){
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
        RecordDao recordDao= (RecordDao) beanFactory.getBean("recordDao");
        return recordDao;
    }
    public CommentDao getCommentDao(){
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
        CommentDao commentDao= (CommentDao) beanFactory.getBean("commentDao");
        return commentDao;
    }
}
