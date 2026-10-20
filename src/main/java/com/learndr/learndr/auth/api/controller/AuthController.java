package com.learndr.learndr.auth.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learndr.learndr.auth.api.dto.request.AddUserDto;
import com.learndr.learndr.auth.application.port.AddUserUseCase;
import com.learndr.learndr.auth.api.mapper.*;

import jakarta.validation.Valid;

@RestController
public class AuthController {
  private AddUserUseCase addUserUseCase;

  public AuthController(AddUserUseCase addUserUseCase) {
    this.addUserUseCase = addUserUseCase;
  }

  @PostMapping("api/auth/addUser")
  public ResponseEntity<Integer> addUser(@Valid @RequestBody AddUserDto addUserRequest) {
    addUserUseCase.execute(AddUserRequestMapper.toAddUserCommand(addUserRequest));
    return ResponseEntity.status(201).build();
  }
}
