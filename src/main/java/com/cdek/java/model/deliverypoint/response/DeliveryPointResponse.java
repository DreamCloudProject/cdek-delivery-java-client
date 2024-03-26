package com.cdek.java.model.deliverypoint.response;

import com.cdek.java.model.common.Cell;
import com.cdek.java.model.common.Location;
import com.cdek.java.model.common.Phone;
import com.cdek.java.model.common.WorkTime;
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
public class DeliveryPointResponse {

    private String code;
    private String name;
    private String cityCode;
    private String countryCode;
    private String postalCode;
    private String city;
    private String address;
    private String region;
    private UUID uuid;
    private Location location;
    private String addressComment;
    private String nearestStation;
    private String nearestMetroStation;
    private String workTime;
    private List<Phone> phones;
    private String email;
    private String note;
    private String type;
    private String ownerCode;
    private Boolean takeOnly;
    private Boolean isHandout;
    private Boolean isReception;
    private Boolean isDressingRoom;
    private Boolean haveCashless;
    private Boolean haveCash;
    private Boolean haveFastPaymentSystem;
    private Boolean allowedCod;
    private Boolean isLtl;
    private Boolean fulfillment;
    private String site;
    private List<OfficeImage> officeImageList;
    private List<WorkTime> workTimeList;
    private List<WorkTime> workTimeExceptions;
    private Float weightMax;
    private Float weightMin;
    private List<Cell> dimensions;
    private List<Error> errors;

}
