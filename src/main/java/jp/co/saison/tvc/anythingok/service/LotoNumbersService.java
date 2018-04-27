package jp.co.saison.tvc.anythingok.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.saison.tvc.anythingok.domain.LotoMaster;
import jp.co.saison.tvc.anythingok.repository.LotoMasterRepository;
import jp.co.saison.tvc.anythingok.web.LotoNumbersChoiceForm;

@Service
public class LotoNumbersService {
    @Autowired
    LotoMasterService lotoMasterService;
    
	private List<LotoNumbersChoiceForm> list;

	public LotoNumbersService() {
		list = new ArrayList<>();
	}

	public List<Integer> getPredictingNumbers() {
    	return Predict();
	}

	public List<LotoNumbersChoiceForm> getList() {
			return list;
	}

	public void addList(LotoNumbersChoiceForm form) {
		list.add(new LotoNumbersChoiceForm(form));
	}

	public void buy() {
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
}
