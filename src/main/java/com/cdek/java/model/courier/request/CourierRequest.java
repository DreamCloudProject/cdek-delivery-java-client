package com.cdek.java.model.courier.request;

import com.cdek.java.model.common.Contact;
import com.cdek.java.model.common.Location;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourierRequest {
  private String cdekNumber;
  private UUID orderUuid;
  private Instant intakeDate;
  private Instant intakeTimeFrom;
  private Instant intakeTimeTo;
  private Instant lunchTimeFrom;
  private Instant lunchTimeTo;
  private String name;
  private Integer weight;
  private Integer length;
  private Integer height;
  private Integer comment;
  private Contact sender;
  private Location fromLocation;
  private boolean needCall;
}
