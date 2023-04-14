package com.malkfilipp.travelplanner.controller;


import com.malkfilipp.travelplanner.domain.user.AppUser;
import com.malkfilipp.travelplanner.exception.UserNotFoundException;
import com.malkfilipp.travelplanner.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final AppUserRepository userRepository;


    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.OK)
    public AppUser profile(@AuthenticationPrincipal AppUser user){
        String userUsername = user.getUsername(); // assuming email is extracted from the JWT token
        Optional<AppUser> optionalUser = this.userRepository.findByUsername(userUsername);
        return optionalUser.orElseThrow(() -> new UserNotFoundException(userUsername));
    }
}
