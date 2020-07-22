package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(value = "/login.html")
    public String tologin(){
        return "login";
    }

    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest request, User user){
        boolean isVAlidUser=userService.Match(user.getSt_id(),user.getPassword());
        if (isVAlidUser){
            request.getSession().setAttribute("User",user.getSt_id()+"登陆成功");
            return new ModelAndView("success");
        }else{
            return new ModelAndView("login");
        }
    }
}
