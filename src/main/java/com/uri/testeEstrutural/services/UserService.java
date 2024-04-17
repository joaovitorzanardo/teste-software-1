package com.uri.testeEstrutural.services;

import com.uri.testeEstrutural.database.InMemoryDatabase;
import com.uri.testeEstrutural.dto.UserDto;
import com.uri.testeEstrutural.exceptions.InvalidUsernameException;
import com.uri.testeEstrutural.exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public UserDto createUser(UserDto userDto) {
        List<UserDto> users = InMemoryDatabase.getRegistratedUsersList();

        if (!isUsernameValid(userDto.getUsername().trim())) {
            throw new InvalidUsernameException();
        }

        boolean foundUser = false;

        for (UserDto user : users) {
            if (user.getUsername().equals(userDto.getUsername())){
                foundUser = true;
                break;
            }
        }

        if (foundUser) {
            throw new UserAlreadyExistsException(userDto.getUsername());
        }

        return InMemoryDatabase.addNewUser(userDto);
    }

    private boolean isUsernameValid(String username) {
        if (username.length() < 5 || username.length() > 8) {
            return false;
        }

        if (!String.valueOf(username.charAt(0)).matches("[a-zA-Z]")) {
            return false;
        }

        if (!username.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }

        return true;
    }

}
