package com.cdek.java.model.webhook.response;

import com.cdek.java.model.common.response.Entity;
import com.cdek.java.model.common.response.Request;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WebhookResponse {
    private Entity entity;
    private List<Request> requests;
}
