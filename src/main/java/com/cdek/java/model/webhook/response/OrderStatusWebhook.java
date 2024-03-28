package com.cdek.java.model.webhook.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderStatusWebhook {
    private String uuid;
    private String name;
    private String identifier;
    private String type;
    private Date dateTime;
    private String url;
    private OrderStatusAttributes attributes;
    private boolean retryable;
}
