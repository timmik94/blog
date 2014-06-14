package DAO;

import Factory.HibernateUtil;
import Hibernateclasses.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
public class HibernateUserDao implements UserDao {
    @Override
    public List<User> getall() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        List<User> users= (List<User>) session.createCriteria(User.class).list();
        return users;
    }

    @Override
    public User getuser(String login) {
        Session session= HibernateUtil.getSessionFactory().openSession();

       List<User> user=null;
            try {
               user = (List<User>) session.createCriteria(User.class).add(Restrictions.eq("login",login)).list();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        session.close();
        if(user.size()>0){
        User us=user.get(0);
        return us;}else{return  null;}



    }

    @Override
    public boolean havelogin(String login) {
        User user=getuser(login);
        if(user==null){return true;}
        return false;
    }

    @Override
    public boolean chekpassword(String login, String password) {
        User user=getuser(login);
         if(user!=null){
         if(user.getPassword().equals(password)){return true;}
        }
        return false;
    }

    @Override
    public void incertUser(String login, String password) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        User user=new User();
        user.setLogin(login);
        user.setPassword(password);
        session.save(user);
        session.close();

    }
}
