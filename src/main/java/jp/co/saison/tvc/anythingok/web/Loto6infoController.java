package jp.co.saison.tvc.anythingok.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.saison.tvc.anythingok.domain.Loto6info;
import jp.co.saison.tvc.anythingok.service.LoginUserDetails;
import jp.co.saison.tvc.anythingok.service.Loto6infoService;

@Controller
@RequestMapping("loto6infos")
public class Loto6infoController {
    @Autowired
    Loto6infoService loto6infoService;

    @ModelAttribute
    Loto6infoForm setUpForm() {
        return new Loto6infoForm();
    }

    @GetMapping
    String list(Model model) {
        List<Loto6info> loto6infos = loto6infoService.findAll();
        model.addAttribute("loto6infos", loto6infos);
        return "loto6infos/list";
    }

    @PostMapping(path = "create")
    String create(@Validated Loto6infoForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        Loto6info loto6info = new Loto6info();
        BeanUtils.copyProperties(form, loto6info);
        loto6infoService.create(loto6info, userDetails.getUser());
        return "redirect:/loto6infos";
    }

    @GetMapping(path = "edit", params = "form")
    String editForm(@RequestParam Integer id, Loto6infoForm form) {
        Loto6info loto6info = loto6infoService.findOne(id);
        BeanUtils.copyProperties(loto6info, form);
        return "loto6infos/edit";
    }

    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, @Validated Loto6infoForm form, BindingResult result,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        Loto6info loto6info = new Loto6info();
        BeanUtils.copyProperties(form, loto6info);
        loto6info.setId(id);
        loto6infoService.update(loto6info, userDetails.getUser());
        return "redirect:/loto6infos";
    }

    @GetMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/loto6infos";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        loto6infoService.delete(id);
        return "redirect:/loto6infos";
    }
}