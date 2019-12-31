package com.cdek.java.client.auth;

public interface CdekAuthentication {

  /**
   * Метод, позволяющий получить jwt токен доступа
   * @return - jwt токен
   */
  String getAccessToken();

}
