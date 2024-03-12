package com.cdek.java.model.auth.response;

import com.cdek.java.client.auth.CdekAuthentication;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AuthResponse implements CdekAuthentication {

  /**
   * Jwt-токен
   */
  private String accessToken;

  /**
   * Тип токена (всегда принимает значение "bearer")
   */
  private String tokenType;

  /**
   * Срок действия токена (по умолчанию 3600 секунд)
   */
  private Integer expiresIn;

  /**
   * Область действия токена (доступ к объектам и операциям над ними)
   */
  private String scope;

  /**
   * Уникальный идентификатор токена
   */
  private String jti;

  /**
   * Ошибка
   */
  private String error;

  /**
   * Сообщение об ошибке
   */
  private String errorDescription;
}
