package com.example.memo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private long id;
    private String name;
    private String mail;
    private String hashedpwd;

}
