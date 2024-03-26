package com.cdek.java.model.courier.response;

import com.cdek.java.model.common.response.Entity;
import com.cdek.java.model.common.response.Error;
import com.cdek.java.model.common.response.Request;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourierResponse {

  private Entity entity;
  private List<Request> requests;
  private List<Error> warnings;
  private List<Entity> relatedEntities;

}
