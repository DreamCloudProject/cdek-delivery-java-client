package com.cdek.java.model.common.response;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Данные об ошибке обработки запроса на стороне ИС СДЭК
 */
@Getter
@Setter
public class Error {

  /**
   * Код ошибки
   */
  @NotNull
  @Size(max = 255)
  private String code;

  /**
   * Описание ошибки
   */
  @NotNull
  @Size(max = 255)
  private String message;

}
