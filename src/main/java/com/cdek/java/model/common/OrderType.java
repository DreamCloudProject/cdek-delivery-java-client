package com.cdek.java.model.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderType {

  ONLINE_STORE,
  DELIVERY;

  @JsonValue
  public int getType() {
    return ordinal() + 1;
  }
}
