package com.cdek.java.model.invoice.response;

import com.cdek.java.model.common.response.Status;
import com.cdek.java.model.common.response.Error;
import com.cdek.java.model.invoice.request.InvoiceRequest;
import java.util.List;

public class InvoiceResponse extends InvoiceRequest {

  private List<Status> statuses;
  private List<Error> errors;


}
