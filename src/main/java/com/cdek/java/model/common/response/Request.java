package com.cdek.java.model.common.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Request {

    private UUID requestUuid;
    private String type;
    private Date dateTime;
    private String state;
    private List<Error> errors;
    private List<Error> warnings;

}
