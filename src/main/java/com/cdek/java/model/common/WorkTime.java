package com.cdek.java.model.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WorkTime {

    private Integer day;
    private String time;
    private String timeStart;
    private String timeEnd;
    private Date date;
    private Date dateStart;
    private Date dateEnd;
    private Boolean isWorking;

}
