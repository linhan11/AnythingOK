package jp.co.saison.tvc.anythingok.web;

import java.security.Principal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.saison.tvc.anythingok.domain.User;
import jp.co.saison.tvc.anythingok.service.LotoUserInfoService;

@Controller
@RequestMapping("loto_users")
public class LotoUserInfoController {
    @Autowired
    LotoUserInfoService lotoUserInfoService;

    @ModelAttribute
    LotoUserInfoForm setUpForm() {
        return new LotoUserInfoForm();
    }

    @GetMapping
    String createForm(Model model) {
        User lotoUser = new User();
        model.addAttribute("loto_users", lotoUser);
        return "loto_users/edit";
    }

    @GetMapping(path = "new")
    String createForm1(Model model) {
        User lotoUser = new User();
        model.addAttribute("loto_users", lotoUser);
        return "loto_users/new";
    }

    @GetMapping(path = "edit")
    String edit(Model model, Principal principal) {
    	Authentication auth = (Authentication)principal;
        User lotoUser = lotoUserInfoService.findOne(auth.getName());
        model.addAttribute("lotoUserInfoForm", lotoUser);
        return "loto_users/edit";
    }

    @PostMapping(path = "new")
    String create111(@Validated LotoUserInfoForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return createForm1(model);
        }
        User lotoUser = new User();
        BeanUtils.copyProperties(form, lotoUser);
        lotoUserInfoService.create(lotoUser);
        return "loto_users/new";
    }

    @GetMapping(path = "edit", params = "user-form")
    String editForm1(String username, LotoUserInfoForm form) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User lotoUser = lotoUserInfoService.findOne(name);
        BeanUtils.copyProperties(lotoUser, form);
        return "loto_users/edit";
    }

    @RequestMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/loto_historys";
    }

    @RequestMapping(path = "new", params = "goToLogin")
    String goToLogin() {
        return "redirect:/loginForm";
    }

    @RequestMapping(path = "new", params = "create")
    String create(@Validated LotoUserInfoForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return createForm1(model);
        }
        User lotoUser = new User();
        BeanUtils.copyProperties(form, lotoUser);
        String psStr = lotoUser.getEncoded_password();
        lotoUser.setEncoded_password(new Pbkdf2PasswordEncoder().encode(psStr));
        lotoUserInfoService.create(lotoUser);
        return "redirect:/loginForm";
    }
}