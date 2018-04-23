package jp.co.saison.tvc.anythingok.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Loto6infoForm {
    @NotNull
    @Size(min = 1, max = 127)
//    private String lotteryNo;
    private String loto_index;
    @NotNull
    @Size(min = 1, max = 127)
//    private String lotteryDate;
    private String purchased_no;
}