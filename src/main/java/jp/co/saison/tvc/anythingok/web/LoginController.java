package jp.co.saison.tvc.anythingok.web;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.saison.tvc.anythingok.domain.User;

@Controller
public class LoginController {
    @GetMapping(path = "loginForm")
    String loginForm() {
        return "loginForm";
    }

    @GetMapping(path = "edit", params = "form")
    String editForm(LotoUserInfoForm form) {
    	User user = new User();
        BeanUtils.copyProperties(user, form);
        return "loto_users/edit";
    }

//    String editForm(LotoUserInfoForm form) {
//    	User user = new User();
//        BeanUtils.copyProperties(user, form);
//        return "loto_users/edit";
//    }
}