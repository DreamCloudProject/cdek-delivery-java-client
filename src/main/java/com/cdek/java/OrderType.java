package com.cdek.java;

public enum OrderType {

  ONLINE_STORE,
  DELIVERY;

  public int getType() {
    return ordinal() + 1;
  }
}
