package mvcclasses;

import DAO.RecordDao;
import Factory.DaoFactory;
import Hibernateclasses.Record;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
@Controller
@RequestMapping("/Users/read")
public class ReadAction {
    @RequestMapping(method = RequestMethod.GET)
public String doGet(@RequestParam(value = "login")String login,HttpSession session,Model m){

        DaoFactory daoFactory=new DaoFactory();
        RecordDao recordDao=daoFactory.getRecordDao();
        List<Record> records=recordDao.getRecordbyuser(login);
        session.setAttribute("records",records);
        return "Users/read";
   }
}
