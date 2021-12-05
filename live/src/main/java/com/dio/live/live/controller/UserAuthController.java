package com.dio.live.live.controller;

import com.dio.live.live.entity.UserAuth;
import com.dio.live.live.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAuthController {
    @Autowired
    UserAuthService userAuthService;

    @PostMapping(value ="/userauth/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUserAuth(@RequestBody UserAuth userAuth) {
        return userAuthService.createUserAuth(userAuth);
    }

    @GetMapping(value = "/userauth/details/{username}/{password}")
    public Boolean verifyUsername(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userAuthService.verifyUsername(username, password);
    }

    @PutMapping(value = "/userauth/update/{idUserAuth}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUserAuth(@PathVariable("idLivro") Long idUserAuth, @RequestBody UserAuth userAuth) {
        return userAuthService.updateUserAuth(userAuth, idUserAuth);
    }

    @DeleteMapping(value = "userauth/delete/{idUserAuth}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteUserAuth(@PathVariable("idUserAuth") Long idUserAuth) {
        return userAuthService.deleteUserAuth(idUserAuth);
    }
}
