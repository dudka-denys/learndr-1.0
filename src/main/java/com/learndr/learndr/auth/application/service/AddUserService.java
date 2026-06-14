package com.learndr.learndr.auth.application.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learndr.learndr.auth.application.dto.command.AddUserCommand;
import com.learndr.learndr.auth.application.port.AddUserUseCase;
import com.learndr.learndr.auth.domain.repository.UserRepository;

@Service
public class AddUserService implements AddUserUseCase {
  private UserRepository userRepository;

  public AddUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void execute(AddUserCommand cmd) {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    String passwordHash = encoder.encode(cmd.password());
    User userWithHash = new User(cmd.user_name(), passwordHash, cmd.preferred_locale(), cmd.fk_role_id())
  }
}
