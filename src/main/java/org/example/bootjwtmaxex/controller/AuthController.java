package org.example.bootjwtmaxex.controller;

import org.apache.coyote.BadRequestException;
import org.example.bootjwtmaxex.model.dto.UserAccountRequestDTO;
import org.example.bootjwtmaxex.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserAccountService userAccountService;

    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(UserAccountRequestDTO dto){
        return ResponseEntity.ok("");
    }

    //join, register
    @PostMapping("/join")
    public ResponseEntity<Void> join(UserAccountRequestDTO dto) throws BadRequestException {
        userAccountService.join(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
