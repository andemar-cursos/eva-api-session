package com.pichincha.eva.session.service;

import com.pichincha.eva.session.service.dto.ClientJwtResponseDto;
import com.pichincha.eva.session.service.dto.ClientLoginDto;

public interface LoginService {
  ClientJwtResponseDto login(ClientLoginDto clientLoginDto);
}
