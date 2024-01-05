package com.pichincha.eva.session.service.impl;

import com.pichincha.eva.session.domain.ClientLogin;
import com.pichincha.eva.session.service.dto.ClientJwtResponseDto;
import com.pichincha.eva.session.service.dto.ClientLoginDto;
import com.pichincha.eva.session.service.LoginService;
import com.pichincha.eva.session.service.mapper.ClientLoginMapper;
import com.pichincha.eva.session.util.JwtUtil;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

  private static final ClientLoginMapper CLIENT_LOGIN_MAPPER = ClientLoginMapper.INSTANCE;
  private final JwtUtil jwtUtil;

  @Override
  public ClientJwtResponseDto login(ClientLoginDto clientLoginDto) {
    ClientLogin clientLogin = CLIENT_LOGIN_MAPPER.toClientLogin(clientLoginDto);

    return Stream.of(clientLogin)
            .map(cl -> jwtUtil.generateJWT(cl.getUser()))
            .map(token -> ClientJwtResponseDto.builder().jwt(token).build())
            .findAny().get();
  }
}
