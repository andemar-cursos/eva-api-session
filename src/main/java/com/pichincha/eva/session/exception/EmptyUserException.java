package com.pichincha.eva.session.exception;

public class EmptyUserException extends Exception {

  public EmptyUserException() {
    super("The user couldn't be empty");
  }
}
