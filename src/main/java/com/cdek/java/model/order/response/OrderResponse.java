package com.cdek.java.model.order.response;

import com.cdek.java.model.common.response.Status;
import com.cdek.java.model.order.request.OrderRequest;
import com.cdek.java.model.common.response.Error;
import java.util.List;

public class OrderResponse extends OrderRequest {

  private List<Status> statuses;
  private List<Error> errors;

}
