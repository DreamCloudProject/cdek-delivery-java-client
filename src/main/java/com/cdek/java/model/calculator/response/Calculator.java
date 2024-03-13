package com.cdek.java.model.calculator.response;

import com.cdek.java.model.common.Service;
import com.cdek.java.model.common.response.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Calculator {

    private Float deliverySum;

    private Integer periodMin;

    private Integer periodMax;

    private Integer weightCalc;

    private List<Service> services;

    private Float totalSum;

    @Size(max = 3)
    private String currency;

    private List<Error> errors;

    private Integer calendarMin;

    private Integer calendarMax;

}
