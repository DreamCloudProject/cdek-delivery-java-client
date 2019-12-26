package com.cdek.java.model.handbook;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OwnershipType {

  JOIN_STOCK_COMPANY(9, "Акционерное общество"),
  CLOSED_JOIN_STOCK_COMPANY(61, "Закрытое акционерное общество"),
  INDIVIDUAL_ENTREPRENEUR(63, "Индивидуальный предпрениматель"),
  PUBLIC_CORPORATION(119, "Открытое акционерное общество"),
  PRIVATE_LIMITED_COMPANY(137, "Общество с ограниченной ответственностью"),
  OPEN_JOINT_STOCK_COMPANY(147, "Публичное акционерное общество");

  private int code;
  private String description;

  OwnershipType(int code, String description) {
    this.code = code;
    this.description = description;
  }

  @JsonValue
  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
}
