package com.cdek.java.model.common.response;

import com.cdek.java.commons.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.Instant;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Статус заказа, заявки
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Status {

  /**
   * Код статуса
   */
  @NotNull
  @Size(max = 255)
  private String status;

  /**
   * Название статуса
   */
  @NotNull
  @Size(max = 255)
  private String name;

  /**
   * Дата и время установки статуса
   */
  @NotNull
  @JsonFormat(pattern = Pattern.DATE_TIME)
  private Instant dateTime;

  /**
   * Дополнительный код статуса
   */
  @Size(max = 2)
  private String reasonCode;

  /**
   * Наименование места возникновения статуса
   */
  @Size(max = 255)
  private String city;
}
