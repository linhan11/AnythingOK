package jp.co.saison.tvc.anythingok.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import lombok.Data;

@Data
public class LotoNumbersChoiceForm {

	private String[] inputMultiCheck;

	public LotoNumbersChoiceForm() {
	}

	public LotoNumbersChoiceForm(LotoNumbersChoiceForm obj) {
		this.inputMultiCheck = obj.inputMultiCheck.clone();
	}

	public void QuickPick() {

		Random rand = new Random();
		List<String> tmp = new ArrayList<>();
		if (inputMultiCheck != null) {
			IntStream.range(0, Math.min(6, inputMultiCheck.length)).forEach(i -> tmp.add(inputMultiCheck[i]));
		}
		while (tmp.size() < 6 ) {
			String num = String.valueOf(rand.nextInt(43) + 1);
			if (!tmp.contains(num)) {
				tmp.add(num);
			}
		}
		inputMultiCheck = new String[tmp.size()];
		tmp.toArray(inputMultiCheck);
	}

}
