package com.cdek.java.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderType {

  ONLINE_STORE,
  DELIVERY;

  @JsonValue
  public int getType() {
    return ordinal() + 1;
  }
}
