package com.cdek.java.model.barcode.request;

import com.cdek.java.model.invoice.request.Order;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarcodeRequest {

  private List<Order> orders;

}
