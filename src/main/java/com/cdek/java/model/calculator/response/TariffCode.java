package com.cdek.java.model.calculator.response;

import com.cdek.java.model.common.response.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TariffCode {

    private Integer tariffCode;

    private String tariffName;

    private String tariffDescription;

    private Integer deliveryMode;

    private Float deliverySum;

    private Integer periodMin;

    private Integer periodMax;

    private Integer calendarMin;

    private Integer calendarMax;

    List<Error> errors;

}
