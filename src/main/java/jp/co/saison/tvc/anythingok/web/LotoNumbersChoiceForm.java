package jp.co.saison.tvc.anythingok.web;

import lombok.Data;

@Data
public class LotoNumbersChoiceForm {

	private String[] inputMultiCheck;

	public LotoNumbersChoiceForm() {
	}

	public LotoNumbersChoiceForm(LotoNumbersChoiceForm obj) {
		this.inputMultiCheck = obj.inputMultiCheck.clone();
	}
}
