package com.dio.live.live.service;

import com.dio.live.live.entity.UserAuth;
import com.dio.live.live.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserAuthService {
    @Autowired
    UserAuthRepository userAuthRepository;

    public ResponseEntity<Object> createUserAuth(UserAuth model) {
        UserAuth userAuth = new UserAuth();

        userAuth.setUsername(model.getUsername());
        userAuth.setPassword(model.getPassword());

        UserAuth saveUserAuth = userAuthRepository.save(userAuth);
        if (userAuthRepository.findById(saveUserAuth.getId()).isPresent()) return ResponseEntity.ok().build();
        else return ResponseEntity.unprocessableEntity().build();
    }
    @Transactional
    public ResponseEntity<Object> updateUserAuth(UserAuth model, Long id) {
        if (userAuthRepository.findById(id).isPresent()) {
            UserAuth userAuth = userAuthRepository.findById(id).get();
            userAuth.setUsername(model.getUsername());
            userAuth.setPassword(model.getPassword());
            UserAuth saveUserAuth = userAuthRepository.save(userAuth);
            if (userAuthRepository.findById(saveUserAuth.getId()).isPresent()) return ResponseEntity.ok().build();
            else return ResponseEntity.unprocessableEntity().build();
        }else return ResponseEntity.unprocessableEntity().build();
    }
    public ResponseEntity<Object> deleteUserAuth(Long id) {
        if (userAuthRepository.findById(id).isPresent()) {
            userAuthRepository.deleteById(id);
            if (userAuthRepository.findById(id).isPresent()) return ResponseEntity.unprocessableEntity().build();
            else return ResponseEntity.ok().build();
        }else return ResponseEntity.badRequest().build();
    }
    public Boolean verifyUsername(String username, String password){
        Optional<UserAuth> userAuth = userAuthRepository.findByUsername(username);
        if (userAuth.isPresent() && userAuth.get().getPassword().equals(password))
            return true;
        else
            return false;
    }
}
