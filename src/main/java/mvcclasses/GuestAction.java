package mvcclasses;

import DAO.UserDao;
import Factory.DaoFactory;
import Hibernateclasses.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
@Controller
@RequestMapping("/guest")
public class GuestAction {
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpSession session){
        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao=daoFactory.getUserDao();
        List<User> users=userDao.getall();
        session.setAttribute("users",users);
        return "guest";
    }
}
