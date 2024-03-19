package com.cdek.java.model.deliverypoint.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DeliveryPointRequest {
    private String postalCode;
    private String cityCode;
    @Size(max = 8)
    private String type;
    @Size(max = 2)
    private String countryCode;
    private Integer regionCode;
    private Boolean haveCashless;
    private Boolean haveCash;
    private Boolean allowedCod;
    private Boolean isDressingRoom;
    private Integer weightMax;
    private Integer weightMin;
    @Size(max = 3)
    private String lang;
    private Boolean takeOnly;
    private Boolean isHandOut;
    private Boolean isReception;
    private UUID fiasGuid;
    @Size(max = 10)
    private String code;
    private String isLtl;
    private Boolean fulfillment;
    private Integer size;
    private Integer page;
}
