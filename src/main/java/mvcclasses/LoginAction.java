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
@RequestMapping("/")
public class LoginAction {
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpSession session,@RequestParam(value = "username")String username,
                         @RequestParam(value = "password")String password,Model m){
        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao=daoFactory.getUserDao();
        if(userDao.chekpassword(username,password)){
            User user=userDao.getuser(username);
            session.setAttribute("user",user);
            return "Users/home";
        }else{return "login";}
    }


}
