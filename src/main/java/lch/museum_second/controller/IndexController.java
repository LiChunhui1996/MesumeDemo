package lch.museum_second.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String GetTreasure(ModelMap modelMap){
        return "index";
    }

    @RequestMapping("/loginPage")
    public String Login(ModelMap modelMap){
        modelMap.addAttribute("items", "error");
        return "login";
    }
}
