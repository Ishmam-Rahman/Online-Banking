package com.onlinebanking.onlinebanking.ExceptionHandle;

public class ResourcesNotFound extends RuntimeException{

  public ResourcesNotFound(String massage) {
    super(massage);
  }

  public ResourcesNotFound(String message, Throwable throwable) {
    super(message, throwable);
  }
}
