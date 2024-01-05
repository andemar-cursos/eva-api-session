package com.pichincha.eva.session.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientLoginDto {
  @NotNull(message = "It's necessary an user")
  @NotBlank(message = "The user couldn't be empty")
  String user;

  @NotNull(message = "It's necessary a password")
  @NotBlank(message = "The password couldn't be empty")
  String password;
}
