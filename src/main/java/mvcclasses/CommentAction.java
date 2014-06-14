package mvcclasses;

import DAO.CommentDao;
import DAO.RecordDao;
import Factory.DaoFactory;
import Hibernateclasses.Comment;
import Hibernateclasses.Record;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
@Controller
@RequestMapping("/Users/comment")
public class CommentAction {
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(@RequestParam(value = "id")long id,HttpSession session){
        DaoFactory daoFactory=new DaoFactory();
        RecordDao recordDao=daoFactory.getRecordDao();
        Record record=recordDao.getrecord(id);
        CommentDao commentDao=daoFactory.getCommentDao();
        List<Comment> comments=commentDao.getbyrecord(id);
        session.setAttribute("record",record);
        session.setAttribute("comment",comments);
        return "Users/comment";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@RequestParam(value = "id") long id,@RequestParam(value = "text")String text,
                         HttpSession session){
        DaoFactory daoFactory=new DaoFactory();
        RecordDao recordDao=daoFactory.getRecordDao();
        Record record=recordDao.getrecord(id);
        Comment comment=new Comment();
        comment.setDate();
        String[] str=text.split("\n");
        text="";
        for (int i=0;i<str.length;i++){
            text=text+str[i]+"<br/>";
        }
        comment.setText(text);
        comment.setRecord(record);
        comment.setUser((Hibernateclasses.User) session.getAttribute("user"));
        CommentDao commentDao=daoFactory.getCommentDao();
        commentDao.incertcomment(comment);
        return this.doGet(id,session);
    }
}
