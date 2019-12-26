package com.cdek.java.client.auth;

import com.cdek.java.model.auth.request.AuthRequest;
import com.cdek.java.model.auth.response.AuthResponse;
import reactor.core.publisher.Mono;

public interface CdekAuthService {

  Mono<AuthResponse> authorize(AuthRequest authRequest);

  String getFreshJWT();

}
