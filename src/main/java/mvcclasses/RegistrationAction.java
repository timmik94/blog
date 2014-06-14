package mvcclasses;

import DAO.UserDao;
import Factory.DaoFactory;
import Hibernateclasses.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by timur on 14.06.2014.
 */
@Controller
@RequestMapping("/reg")
public class RegistrationAction {
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@RequestParam(value = "login")  String login,
                       @RequestParam(value = "password") String password,
                       HttpSession session,Model m){
        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao=daoFactory.getUserDao();
        if(!userDao.havelogin(login)){
            m.addAttribute("message","login not exist");
            return "Registration";
        }
        if(password.length()<6){
            m.addAttribute("message","short password");
            return "Registration";
        }
        userDao.incertUser(login,password);
        User user=userDao.getuser(login);
        user.getLogin();
        session.setAttribute("user",user);
        return "Users/home";

    }
}
