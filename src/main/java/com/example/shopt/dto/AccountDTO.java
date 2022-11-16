package com.example.shopt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {

    private String login;
    private String password;
    private String mail;

}
