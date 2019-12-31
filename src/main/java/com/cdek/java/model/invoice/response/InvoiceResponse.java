package com.cdek.java.model.invoice.response;

import com.cdek.java.model.common.response.Status;
import com.cdek.java.model.common.response.Error;
import com.cdek.java.model.invoice.request.InvoiceRequest;
import com.cdek.java.model.invoice.request.Order;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class InvoiceResponse {

  private UUID uuid;

  private List<Order> orders;

  private Integer copyCount;

  private String type;

  private String url;

  private List<Status> statuses;

  private List<Error> errors;


}
