package jp.co.saison.tvc.anythingok.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.saison.tvc.anythingok.domain.LotoMaster;
import jp.co.saison.tvc.anythingok.service.LotoMasterService;;

@Controller
@RequestMapping("loto_masters")
public class LotoMasterController {
    @Autowired
    LotoMasterService lotoMasterService;

//    @GetMapping(path = "list")
//    String list(Model model) {
//        List<LotoMaster> lotoMasters = lotoMasterService.findAll();
//        model.addAttribute("loto_masters", lotoMasters);
//        return "loto_masters/list";
//    }

    @GetMapping(path = "list")
    String list(Model model, Pageable pageable) {
    	Page<LotoMaster> lotoMastersPage = lotoMasterService.findAll(pageable);

        model.addAttribute("page", lotoMastersPage);
        model.addAttribute("loto_masters", lotoMastersPage.getContent());
        model.addAttribute("url", "/loto_masters/list");
//        List<LotoMaster> lotoMasters = lotoMasterService.findAll();
//        model.addAttribute("loto_masters", lotoMasters);
        return "loto_masters/list";
    }
}
