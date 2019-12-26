package com.cdek.java.model.auth.response;

import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

  /**
   * Jwt-токен
   */
  private String accessToken;

  /**
   * Тип токена (всегда принимает значение "bearer")
   */
  private TokenType tokenType;

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
