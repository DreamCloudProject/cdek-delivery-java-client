package com.cdek.java.model.invoice;

import com.cdek.java.model.common.response.Status;
import com.cdek.java.model.common.response.Error;
import java.util.List;

public class InvoiceResponse extends InvoiceRequest {

  private List<Status> statuses;
  private List<Error> errors;


}
