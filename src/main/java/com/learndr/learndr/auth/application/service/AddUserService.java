package com.learndr.learndr.auth.application.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learndr.learndr.auth.application.dto.command.AddUserCommand;
import com.learndr.learndr.auth.application.exception.EmailAlreadyExistException;
import com.learndr.learndr.auth.application.port.AddUserUseCase;
import com.learndr.learndr.auth.domain.entity.User;
import com.learndr.learndr.auth.domain.repository.UserRepository;

@Service
public class AddUserService implements AddUserUseCase {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  public AddUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void execute(AddUserCommand cmd) {
    if (userRepository.existsByEmail(cmd.email()))
      throw new EmailAlreadyExistException(cmd.email());
    else {
      String passwordHash = passwordEncoder.encode(cmd.password());
      User userWithHash = new User(cmd.userName(), cmd.email(), passwordHash, cmd.preferredLocale());
      userRepository.save(userWithHash);
    }
  }
}
