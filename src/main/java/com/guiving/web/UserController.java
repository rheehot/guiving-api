package com.guiving.web;

import com.guiving.service.UserService;
import com.guiving.web.dto.user.UserSaveRequestDto;
import com.guiving.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/user")
    public ResponseEntity<?> save(UserSaveRequestDto request) throws Exception {
        ResponseEntity<?> result;
        try {
            Long id = userService.save(request);
            result = new ResponseEntity<>(userService.findById(id), HttpStatus.OK) ;
        }
        catch(Exception e) {
            e.printStackTrace();
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST) ;
        }
        return result;
    }

    @PutMapping("/api/v1/user")
    public ResponseEntity<?> update(Long id, UserUpdateRequestDto request) throws Exception {
        ResponseEntity<?> result;
        try {
            userService.update(id,request);
            result = new ResponseEntity<>(userService.findById(id), HttpStatus.OK) ;
        }
        catch(Exception e) {
            e.printStackTrace();
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST) ;
        }
        return result;
    }
}
