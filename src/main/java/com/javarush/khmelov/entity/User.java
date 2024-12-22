package com.javarush.khmelov.entity;

import com.javarush.khmelov.game.StatisticUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String email;

    private Long id;

    private String login;

    private String password;

    private Role role;
    private StatisticUser statisticUsers;

    public String getImage() { //TODO move to DTO
        return "image-" + id;
    }

}
