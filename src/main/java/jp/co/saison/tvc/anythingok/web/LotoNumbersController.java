package jp.co.saison.tvc.anythingok.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.saison.tvc.anythingok.service.LotoNumbersService;

@Controller
public class LotoNumbersController {

	@Autowired
	private LotoNumbersService service;

    @ModelAttribute
    LotoNumbersChoiceForm setUpForm() {
        return new LotoNumbersChoiceForm();
    }

    @GetMapping("/loto_numbers/choice")
	public String choice(LotoNumbersChoiceForm form, Model model) {
    	model.addAttribute("predictingNumbers", service.getPredictingNumbers());
    	model.addAttribute("form", form);
    	model.addAttribute("list", service.getList());
    	model.addAttribute("loto", service.getLoto());
		return "loto_numbers/choice";
	}

    @PostMapping("/loto_numbers/create")
    String create(@Validated @ModelAttribute LotoNumbersChoiceForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return choice(form, model);
        }
        
        service.addList(form);
    	return "redirect:/loto_numbers/choice";
    }

    @PostMapping("/loto_numbers/buy")
    String buy(@Validated @ModelAttribute LotoNumbersChoiceForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return choice(form, model);
        }
        service.buy();
    	return "redirect:/loto_numbers/choice";
    }
}
