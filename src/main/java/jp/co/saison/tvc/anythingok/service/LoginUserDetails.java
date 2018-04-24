package jp.co.saison.tvc.anythingok.service;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.co.saison.tvc.anythingok.domain.User;
import lombok.Data;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
    private final User user;

    public LoginUserDetails(User user) {
        super(user.getUsername(), user.getEncoded_password(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }
}