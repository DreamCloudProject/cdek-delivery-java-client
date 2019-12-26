package com.cdek.java.model.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Country {

  RUSSIA("00");

  /**
   * Код страны в формате  ISO_3166-1_alpha-2
   */
  private String code;

  Country(String code) {
    this.code = code;
  }

  @JsonValue
  public String getCode() {
    return code;
  }
}
