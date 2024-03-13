package com.cdek.java.client.auth.service;

import com.cdek.java.commons.Api;
import com.cdek.java.model.auth.request.AuthRequest;
import com.cdek.java.model.auth.response.AuthResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CdekAuthServiceImpl implements CdekAuthService {

  @Value("${client.id:EMscd6r9JnFiQ3bLoyjJY6eM78JrJceI}")
  private String clientId;
  @Value("${client.secret:PjLZkKBHEiLK3YsjtNrt3TGNG0ahs3kG}")
  private String clientSecret;

  private final WebClient webClient;

  public static final String AUTH_HEADER = "Authorization";
  private static final String authUrl = Api.version + "/oauth/token";

  private final static String AUTHORIZATION_KEY = "authorization";
  private final ConcurrentHashMap<String, AuthResponse> authorization = new ConcurrentHashMap<>();

  @Override
  public Mono<AuthResponse> authorize(AuthRequest authRequest) {
    return webClient
            .post()
            .uri(uriBuilder ->
                    uriBuilder.path(authUrl)
                            .queryParam("grant_type", authRequest.getGrantType().name().toLowerCase())
                            .queryParam("client_id", authRequest.getClientId())
                            .queryParam("client_secret", authRequest.getClientSecret())
                            .build())
            .retrieve()
            .bodyToMono(AuthResponse.class);
  }

  @Override
  public String getFreshJWT() {
    var auth = authorization.get(AUTHORIZATION_KEY);
    var doAuthRequest = false;
    if (auth == null) {
      doAuthRequest = true;
    } else {
      var now = Instant.now();
      var received = Instant.now();
      var expiresIn = auth.getExpiresIn();
      if (Duration.between(now, received).toSeconds() > expiresIn) {
        doAuthRequest = true;
      }
    }
    if (doAuthRequest) {
      authorize(new AuthRequest(clientId, clientSecret))
              .doOnNext(authResponse -> authorization.put(AUTHORIZATION_KEY, authResponse))
              .block();
    }
    return "Bearer " + authorization.get(AUTHORIZATION_KEY).getAccessToken();
  }
}
