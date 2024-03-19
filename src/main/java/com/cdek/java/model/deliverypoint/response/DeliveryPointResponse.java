package com.cdek.java.model.deliverypoint.response;

import com.cdek.java.model.common.Location;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DeliveryPointResponse {

    private String code;
    private String name;
    private UUID uuid;
    private Location location;

}
