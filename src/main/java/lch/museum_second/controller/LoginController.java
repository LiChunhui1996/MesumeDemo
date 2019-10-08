package lch.museum_second.controller;

import lch.museum_second.domain.Admin;
import lch.museum_second.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    private List<Admin> admins;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginByTelephoneOrEmail(HttpServletRequest request, HttpSession session) {
        String loginInfo = request.getParameter("login_info");
        String loginPassword = request.getParameter("login_password");


        if (loginInfo.contains("@")) {
            System.out.println("邮件登陆！");
            admins = adminService.selectByEmailService(loginInfo);
            System.out.println(admins.toString());
        } else {
            System.out.println("电话登陆！");
            admins = adminService.selectByTelephoneService(loginInfo);
            System.out.println(admins.toString());
        }
        if (checkLogin(admins, loginPassword)) {
            System.out.println("登陆成功！");
            return "redirect:/admin_page";
        } else {
            System.out.println("登陆失败！");
            return "redirect:/loginPage";
        }
    }

    @RequestMapping(value = "/admin_page", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginSuccess(ModelMap modelMap) {
        modelMap.addAttribute("items", admins);
        return "admin";
    }



    private boolean checkLogin(List<Admin> admins, String password) {
        if (admins.size() == 1 && admins.get(0).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


}
