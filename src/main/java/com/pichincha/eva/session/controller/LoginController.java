package com.pichincha.eva.session.controller;

import com.pichincha.eva.session.exception.EmptyPasswordException;
import com.pichincha.eva.session.exception.EmptyUserException;
import com.pichincha.eva.session.service.dto.ClientJwtResponseDto;
import com.pichincha.eva.session.service.dto.ClientLoginDto;
import com.pichincha.eva.session.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/login")
@RequiredArgsConstructor
@Log4j2
public class LoginController {

  private final LoginService loginService;

  @PostMapping("")
  public ResponseEntity<ClientJwtResponseDto> loginClient(@RequestBody @Valid ClientLoginDto clientLogin)
      throws EmptyUserException, EmptyPasswordException {
    log.info("Login | client: " + clientLogin.getUser());
    ClientJwtResponseDto response = loginService.login(clientLogin);
    log.info("Login successfully client: " + clientLogin.getUser());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
