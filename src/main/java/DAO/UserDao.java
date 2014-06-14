package DAO;

import Hibernateclasses.User;

import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
public interface UserDao {
    public List<User> getall();
    public User getuser(String login);
    public boolean havelogin(String login);
    public boolean chekpassword(String login,String password);
    public void incertUser(String login,String password);

}
