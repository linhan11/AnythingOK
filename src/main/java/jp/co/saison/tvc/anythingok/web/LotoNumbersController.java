package jp.co.saison.tvc.anythingok.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LotoNumbersController {

	private Map<String,String> getPredictingNumbers(){
    	List<Integer> seeds = new ArrayList<>();
    	IntStream.rangeClosed(1, 43).forEach(seeds::add);
    	Collections.shuffle(seeds);

    	Map<String, String> numbers = new LinkedHashMap<String, String>();
    	seeds.stream().forEach(i -> numbers.put(String.valueOf(i), String.valueOf(i)));
    	return numbers;
	}

    @GetMapping("/loto_numbers/choice")
	public String choice(LotoNumbersChoiceForm form, Model model) {
    	model.addAttribute("getPredictingNumbers", getPredictingNumbers());
    	model.addAttribute("lotoNumbersChoiceForm", form);
		return "loto_numbers/choice";
	}

    @PostMapping("/loto_numbers/create")
    String create(@Validated @ModelAttribute LotoNumbersChoiceForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return choice(form, model);
        }
    	return "redirect:/loto_numbers/choice";
    }
}
