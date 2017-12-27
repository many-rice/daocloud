package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private User user;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(User user){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("user/createSuccess");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(path = "/register",params = {"!c1","c2=3"})
    public String register(@RequestHeader("Accept-Language") String accpetLanguage){
        System.out.println("________________"+accpetLanguage);
        return "user/register";
    }

    @ResponseBody
    @RequestMapping(value = "/books/{bookId}",method = RequestMethod.GET)
    public String findBook(@PathVariable String bookId,@MatrixVariable int a){
        System.out.println(a);
        return "success";
    }
}
