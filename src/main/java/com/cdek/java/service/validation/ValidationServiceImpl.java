package com.cdek.java.service.validation;

import com.cdek.java.exception.CdekProxyException;
import com.cdek.java.model.barcode.request.BarcodeRequest;
import com.cdek.java.model.courier.request.CourierRequest;
import com.cdek.java.model.invoice.request.InvoiceRequest;
import com.cdek.java.model.order.request.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

  @Override
  public void validateOrderRequest(OrderRequest orderRequest) {

  }

  @Override
  public void validateCourierRequest(CourierRequest courierRequest) throws CdekProxyException {

  }

  @Override
  public void validateInvoiceRequest(InvoiceRequest invoiceRequest) throws CdekProxyException {

  }

  @Override
  public void validateBarcodeRequest(BarcodeRequest barcodeRequest) throws CdekProxyException {

  }
}
