package com.learndr.learndr.auth.api.mapper;

import com.learndr.learndr.auth.api.dto.request.AddUserDto;
import com.learndr.learndr.auth.application.dto.command.AddUserCommand;
import com.learndr.learndr.auth.domain.entity.Locale;
import com.learndr.learndr.auth.domain.entity.RoleId;

public class AddUserRequestMapper {
  public static AddUserCommand toAddUserCommand(AddUserDto addUserReq) {
    return new AddUserCommand(
        addUserReq.userName(),
        addUserReq.email(),
        Locale.valueOf(addUserReq.preferredLocale().toUpperCase()),
        addUserReq.password(),
        new RoleId(addUserReq.roleId()));
  }
}