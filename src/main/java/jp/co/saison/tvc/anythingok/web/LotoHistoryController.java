package jp.co.saison.tvc.anythingok.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.saison.tvc.anythingok.domain.LotoHistory;
import jp.co.saison.tvc.anythingok.domain.LotoMaster;
import jp.co.saison.tvc.anythingok.service.LoginUserDetails;
import jp.co.saison.tvc.anythingok.service.LotoHistoryService;
import jp.co.saison.tvc.anythingok.service.LotoMasterService;;

@Controller
@RequestMapping("loto_historys")
public class LotoHistoryController {
    @Autowired
    LotoHistoryService lotoHistoryService;
    @Autowired
    LotoMasterService lotoMasterService;

    @ModelAttribute
    Loto6infoForm setUpForm() {
        return new Loto6infoForm();
    }

    @GetMapping
    String list(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        List<LotoHistory> lotoHistorys = lotoHistoryService.findByUserName(name);
        model.addAttribute("loto_historys", lotoHistorys);
        return "loto_historys/list";
    }

    @PostMapping(path = "create")
    String create(@Validated Loto6infoForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails, Principal principal) {
        if (result.hasErrors()) {
            return list(model);
        }
        LotoHistory lotoHistory = new LotoHistory();
        BeanUtils.copyProperties(form, lotoHistory);
        lotoHistoryService.create(lotoHistory, userDetails.getUser());
        return "redirect:/loto_historys";
    }

    @GetMapping(path = "edit", params = "form")
    String editForm(@RequestParam Integer id, Loto6infoForm form) {
    	LotoHistory lotoHistory = lotoHistoryService.findOne(id);
    	LotoMaster lotoMaster = lotoMasterService.findOne(lotoHistory.getLoto_index());
        if (lotoMaster == null) {
        	lotoHistory.setLoto_date("");
        	lotoHistory.setVictory_number("");
        }else {
        	lotoHistory.setLoto_date(lotoMaster.getLoto_date());
        	lotoHistory.setVictory_number(lotoMaster.getVictory_number());
        }
        BeanUtils.copyProperties(lotoHistory, form);
        return "loto_historys/edit";
    }

    @GetMapping(path = "edit", params = "new")
    String createFrom(Loto6infoForm form) {
        LotoHistory lotoHistory = new LotoHistory();
        BeanUtils.copyProperties(lotoHistory, form);
        return "loto_historys/edit";
    }

    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, @Validated Loto6infoForm form, BindingResult result,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        LotoHistory lotoHistory = new LotoHistory();
        BeanUtils.copyProperties(form, lotoHistory);
        lotoHistory.setId(id);
        lotoHistoryService.update(lotoHistory, userDetails.getUser());
        return "redirect:/loto_historys";
    }

    @PostMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/loto_historys";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
    	lotoHistoryService.delete(id);
        return "redirect:/loto_historys";
    }
}