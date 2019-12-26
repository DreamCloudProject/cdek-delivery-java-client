package com.cdek.java.model.auth.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthRequest {

  /**
   *
   */
  private GrantType grantType;
  private String clientId;
  private String clientSecret;

  public AuthRequest(String clientId, String clientSecret) {
    grantType = GrantType.CLIENT_CREDENTIALS;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }
}
