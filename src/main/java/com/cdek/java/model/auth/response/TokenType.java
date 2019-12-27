package com.cdek.java.model.auth.response;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TokenType {

  BEARER;

  private final static TokenType[] VALUES = TokenType.values();

  @JsonCreator
  public TokenType parse(final String tokenType) {
    for (var type : VALUES) {
      if (tokenType.toLowerCase().equals(tokenType)) {
        return type;
      }
    }

    throw new IllegalArgumentException("Token type " + tokenType + " doesn't found.");
  }

}
