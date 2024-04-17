package com.uri.testeEstrutural.database;

import com.uri.testeEstrutural.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {

    private static List<UserDto> users;

    public static List<UserDto> getRegistratedUsersList() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public static UserDto addNewUser(UserDto userDto) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(userDto);
        return userDto;
    }

}
