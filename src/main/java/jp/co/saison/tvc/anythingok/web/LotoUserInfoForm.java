package jp.co.saison.tvc.anythingok.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LotoUserInfoForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String username;
    @NotNull
    @Size(min = 1, max = 127)
    private String user_email;
    @NotNull
    @Size(min = 1, max = 127)
    private String encoded_password;
}