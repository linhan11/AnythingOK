package jp.co.saison.tvc.anythingok.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import jp.co.saison.tvc.anythingok.domain.LotoMaster;
import jp.co.saison.tvc.anythingok.web.LotoNumbersChoiceForm;

@Service
public class LotoNumbersService {

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
    	List<Integer> numbers = new ArrayList<>();
    	IntStream.rangeClosed(1, 43).forEach(numbers::add);
    	Collections.shuffle(numbers);
    	return numbers;
	}

	public List<LotoNumbersChoiceForm> getList() {
			return list;
	}

	public void addList(LotoNumbersChoiceForm form) {
		form.QuickPick();
		list.add(new LotoNumbersChoiceForm(form));
	}

	public void buy() {
		list.clear();
	}

	public void delete(Integer index) {
		list.remove(index.intValue());
	}

	public LotoMaster getLoto() {
		return loto;
	}
}
