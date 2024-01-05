package com.pichincha.eva.session.service.mapper;

import com.pichincha.eva.session.domain.ClientLogin;
import com.pichincha.eva.session.service.dto.ClientLoginDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface ClientLoginMapper {
  ClientLoginMapper INSTANCE = Mappers.getMapper(ClientLoginMapper.class);

  ClientLogin toClientLogin(ClientLoginDto clientLoginDto);
}
