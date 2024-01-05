package com.pichincha.eva.session.exception;

public class EmptyPasswordException extends Exception {

  public EmptyPasswordException() {
    super("The password couldn't be empty");
  }
}
