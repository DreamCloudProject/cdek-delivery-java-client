package com.cdek.java.model.webhook.response;

import com.cdek.java.model.common.response.Entity;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderStatusAttributes {

    private boolean isReturn;
    private boolean isReverse;
    private boolean isClientReturn;
    private String cdekNumber;
    private String number;
    private List<Entity> relatedEntities;
    private String statusCode;
    private String statusReasonCode;
    private Date statusDateTime;
    private String cityName;
    private String cityCode;
    private String code;
}
