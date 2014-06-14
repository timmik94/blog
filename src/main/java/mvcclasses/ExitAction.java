package mvcclasses;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by timur on 14.06.2014.
 */
@Controller
@RequestMapping("/Users/exit")
public class ExitAction {
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpSession session){
        session.setAttribute("user", null);
        return "login";
    }
}
