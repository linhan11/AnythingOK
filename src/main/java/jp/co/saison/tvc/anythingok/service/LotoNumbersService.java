package jp.co.saison.tvc.anythingok.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import jp.co.saison.tvc.anythingok.web.LotoNumbersChoiceForm;

@Service
public class LotoNumbersService {

	private List<LotoNumbersChoiceForm> list;

	public LotoNumbersService() {
		list = new ArrayList<>();
	}

	public List<Integer> getPredictingNumbers() {
    	List<Integer> numbers = new ArrayList<>();
    	IntStream.rangeClosed(1, 43).forEach(numbers::add);
    	Collections.shuffle(numbers);
    	return numbers;
	}

	public List<LotoNumbersChoiceForm> getList() {
			return list;
	}

	public void addList(LotoNumbersChoiceForm form) {
		list.add(new LotoNumbersChoiceForm(form));
	}
}
