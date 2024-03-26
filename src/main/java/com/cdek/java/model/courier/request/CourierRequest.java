package com.cdek.java.model.courier.request;

import com.cdek.java.model.common.Contact;
import com.cdek.java.model.common.Location;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourierRequest {
  private String cdekNumber;
  private UUID orderUuid;
  private String intakeDate;
  private String intakeTimeFrom;
  private String intakeTimeTo;
  private String lunchTimeFrom;
  private String lunchTimeTo;
  private String name;
  private Integer weight;
  private Integer width;
  private Integer length;
  private Integer height;
  private String comment;
  private Contact sender;
  private Location fromLocation;
  private boolean needCall;
}
