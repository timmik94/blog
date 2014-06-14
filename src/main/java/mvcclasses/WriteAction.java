package mvcclasses;

import DAO.RecordDao;
import Factory.DaoFactory;
import Hibernateclasses.Record;
import Hibernateclasses.User;
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
@RequestMapping("/Users/write")
public class WriteAction {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpSession session,Model m){
        User user= (User) session.getAttribute("user");
        DaoFactory daoFactory=new DaoFactory();
        RecordDao recordDao=daoFactory.getRecordDao();
        List<Record> records=recordDao.getRecordbyuser(user.getLogin());
        session.setAttribute("records",records);
        return "redirect:/Users/Redact.jsp";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@RequestParam(value = "title") String title,@RequestParam(value = "text") String text,
                         Model m,HttpSession session){
        Record record=new Record();
        String[] str=text.split("\n");
        text="";
        for (int i=0;i<str.length;i++){
            text=text+str[i]+"<br/>";
        }
        record.setText(text);
        record.setTitle(title);
        record.setUser((User) session.getAttribute("user"));
        record.setDate();
        DaoFactory daoFactory=new DaoFactory();
        RecordDao recordDao=daoFactory.getRecordDao();
        recordDao.incertRecord(record);
        return this.doGet(session,m);
    }
}
