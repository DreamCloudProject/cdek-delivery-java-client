package com.cdek.java.model.calculator.request;

import com.cdek.java.model.common.Location;
import com.cdek.java.model.common.Service;
import com.cdek.java.model.order.request.Package;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CalculatorRequest {

    private Date date;

    private Integer type;

    private List<Integer> additionalOrderTypes;

    private Integer currency;

    private Integer tariffCode;

    private Location fromLocation;

    private Location toLocation;

    private List<Service> services;

    private List<Package> packages;

}
