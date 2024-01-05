package com.pichincha.eva.session.util;

import com.pichincha.eva.session.domain.ClientLogin;
import com.pichincha.eva.session.exception.EmptyPasswordException;
import com.pichincha.eva.session.exception.EmptyUserException;
import java.util.Objects;

public class ValidationUtil {

  private ValidationUtil() {}

  public static void clientLoginCheck(ClientLogin clientLogin)
      throws EmptyUserException, EmptyPasswordException {

      if(Objects.isNull(clientLogin)) {
        throw new IllegalArgumentException();
      }

      if(Objects.isNull(clientLogin.getUser()) || clientLogin.getUser().isBlank()) {
        throw new EmptyUserException();
      }

      if(Objects.isNull(clientLogin.getPassword()) || clientLogin.getPassword().isBlank()) {
        throw new EmptyPasswordException();
      }
  }

}
