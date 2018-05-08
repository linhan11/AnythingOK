package jp.co.saison.tvc.anythingok.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.saison.tvc.anythingok.domain.LotoHistory;

import jp.co.saison.tvc.anythingok.domain.LotoMaster;
import jp.co.saison.tvc.anythingok.web.LotoNumbersChoiceForm;

@Service
public class LotoNumbersService {
    @Autowired
    LotoMasterService lotoMasterService;
    @Autowired
    LotoHistoryService lotoHistoryService;
    
	private List<LotoNumbersChoiceForm> list;
    private LotoMaster loto;

	public LotoNumbersService() {
		list = new ArrayList<>();
		loto = new LotoMaster();
		loto.setLoto_index("3456");
		loto.setLoto_date("2018/05/14");
		loto.setCarry_over("123456789");
	}

	public List<Integer> getPredictingNumbers() {
    	return Predict();
	}

	public List<LotoNumbersChoiceForm> getList() {
			return list;
	}

	public void addList(LotoNumbersChoiceForm form) {
		form.QuickPick();
		list.add(new LotoNumbersChoiceForm(form));
	}

	public void buy(LotoHistory history) {
		list.stream()
		.map(e -> String.join(",", e.getInputMultiCheck()))
		.forEach(e -> {
			history.setPurchased_no(e);
			lotoHistoryService.create(history);
			});
		list.clear();
	}
	
	private List<Integer> Predict() {
        List<LotoMaster> lotoMasters = lotoMasterService.findAll();
        Map<String, Long> victoryNumbers = lotoMasters.stream()
        		.map(e -> e.getVictory_number().split(","))
        		.flatMap(Arrays::stream)
        		.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        List<Integer> sortedKeys = victoryNumbers.entrySet().stream()
        		.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        		.map(e -> Integer.parseInt(e.getKey()))
        		.collect(Collectors.toList());
        return sortedKeys;
	}
	
	public void delete(Integer index) {
		list.remove(index.intValue());
	}

	public LotoMaster getLoto() {
		return loto;
	}
}
