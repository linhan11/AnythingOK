package jp.co.saison.tvc.anythingok.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loto_masters")
public class LotoMaster {
    @Id
    @GeneratedValue
    private String loto_index;
    private String loto_date;
    private String victory_number;
    private String victory_amount;
    private String victory_people;
    private String carry_over;

}