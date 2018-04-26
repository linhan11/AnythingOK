package jp.co.saison.tvc.anythingok.web;

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

    @GetMapping(path = "create")
    String createForm1(Model model) {
        User lotoUser = new User();
        model.addAttribute("loto_users", lotoUser);
        return "loto_users/edit";
    }

    @GetMapping(path = "edit")
    String edit(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
    	String name = "user1";
        User lotoUser = lotoUserInfoService.findOne(name);
        model.addAttribute("loto_users", lotoUser);
        return "loto_users/edit";
    }

    @PostMapping(path = "create")
    String create111(@Validated LotoUserInfoForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return createForm1(model);
        }
        User lotoUser = new User();
        BeanUtils.copyProperties(form, lotoUser);
        lotoUserInfoService.create(lotoUser);
        return "loto_users/edit";
    }

    @GetMapping(path = "edit", params = "user-form")
    String editForm1(String username, LotoUserInfoForm form) {
//    	LotoUser lotoUser = lotoUserInfoService.findOne(username);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User lotoUser = lotoUserInfoService.findOne(name);
//        lotoUser.setUsername(name);
//        lotoUser.setUser_email("a@a111");
//        lotoUser.setEncoded_password("1111111XXXXXXXXXXXXX");
//       lotoUser.setEncoded_password("*********************");
        BeanUtils.copyProperties(lotoUser, form);
        form.setEncoded_password("**********");
        return "loto_users/edit";
    }

    @GetMapping(path = "edit", params = "new-form")
    String createForm1(String username, LotoUserInfoForm form) {
//    	LotoUser lotoUser = lotoUserInfoService.findOne(username);
        User lotoUser = new User();
//        lotoUser.setUsername(name);
//        lotoUser.setUser_email("a@a111");
//        lotoUser.setEncoded_password("1111111XXXXXXXXXXXXX");
        BeanUtils.copyProperties(lotoUser, form);
        return "loginForm";
    }

    @RequestMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/loto_historys";
    }

    @RequestMapping(path = "edit", params = "create")
    String create(@Validated LotoUserInfoForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return createForm1(model);
        }
        User lotoUser = new User();
        BeanUtils.copyProperties(form, lotoUser);
        String psStr = lotoUser.getEncoded_password();
        lotoUser.setEncoded_password(new Pbkdf2PasswordEncoder().encode(psStr));
        lotoUserInfoService.create(lotoUser);
        return "redirect:/loto_historys";
    }
}