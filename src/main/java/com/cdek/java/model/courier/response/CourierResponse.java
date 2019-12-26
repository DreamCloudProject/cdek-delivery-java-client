package com.cdek.java.model.courier.response;

import com.cdek.java.model.common.response.Status;
import com.cdek.java.model.courier.request.CourierRequest;
import com.cdek.java.model.common.response.Error;
import java.util.List;

public class CourierResponse extends CourierRequest {

  private List<Status> statuses;
  private List<Error> errors;

}
