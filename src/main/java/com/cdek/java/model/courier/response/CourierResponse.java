package com.cdek.java.model.courier.response;

import com.cdek.java.model.common.response.Status;
import com.cdek.java.model.courier.request.CourierRequest;
import com.cdek.java.model.common.response.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourierResponse extends CourierRequest {

  private List<Status> statuses;
  private List<Error> errors;

}
