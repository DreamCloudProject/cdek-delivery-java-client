package com.cdek.java.model.deliverypoint.response;

import com.cdek.java.model.common.*;
import com.cdek.java.model.common.response.Error;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WidgetDeliveryPoint {
    private String cityCode;
    private String city;
    private String type;
    private String postalCode;
    private String countryCode;
    private String region;
    private Boolean haveCashless;
    private Boolean haveCash;
    private Boolean allowedCod;
    private Boolean isDressingRoom;
    private String code;
    private String name;
    private String address;
    private String workTime;
    private List<Double> location;
    private List<Double> position;
    private Bounds bounds;
    private String kind;
    private String precision;
    private String formatted;
    private List<Component> components;
    private Float weightMax;
    private Float weightMin;
    private List<Cell> dimensions;
    private UUID uuid;
    private String addressComment;
    private String nearestStation;
    private String nearestMetroStation;
    private List<Phone> phones;
    private String email;
    private String note;
    private String ownerCode;
    private Boolean takeOnly;
    private Boolean isHandout;
    private Boolean isReception;
    private Boolean haveFastPaymentSystem;
    private Boolean isLtl;
    private Boolean fulfillment;
    private String site;
    private List<OfficeImage> officeImageList;
    private List<WorkTime> workTimeList;
    private List<WorkTime> workTimeExceptions;
    private List<Error> errors;
}
