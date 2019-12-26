package com.cdek.java.model.common;

public enum OrderTariff {

  INTERNATIONAL_EXPRESS_DOCUMENTS_DOOR_DOOR(7),
  ;

  private int code;

  OrderTariff(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
