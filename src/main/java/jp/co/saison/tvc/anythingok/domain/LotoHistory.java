package jp.co.saison.tvc.anythingok.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.w3c.dom.html.HTMLIsIndexElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loto_historys")
public class LotoHistory {
    @Id
    @GeneratedValue
    private Integer id;
    private String user_id;
    private String loto_index;
    private String purchased_no;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true, name = "username")
    private User user;
    private String loto_date;
    private String victory_number;
    private String purchased_result;
    private String purchased_money;    
    
	public LotoHistory(User user, String loto_index, String loto_date) {
		this.user_id = user.getUsername();
		this.user = user;
		this.loto_index = loto_index;
		this.loto_date = loto_date;
		this.victory_number = "******";
		this.purchased_result = "******";
		this.purchased_money = "******";
	}     

}