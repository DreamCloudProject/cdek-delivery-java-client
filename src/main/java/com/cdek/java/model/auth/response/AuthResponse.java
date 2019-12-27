package com.cdek.java.model.auth.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AuthResponse {

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

  private Instant received = Instant.now();

  /**
   * Область действия токена (доступ к объектам и операциям над ними)
   */
  private String scope;

  /**
   * Уникальный идентификатор токена
   */
  private UUID jti;
}
