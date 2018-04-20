package jp.co.saison.tvc.anythingok.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Loto6infoForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String lotteryNo;
    @NotNull
    @Size(min = 1, max = 127)
    private String lotteryDate;
}