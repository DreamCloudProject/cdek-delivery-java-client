package com.cdek.java.service.validation;

import com.cdek.java.exception.CdekProxyException;
import com.cdek.java.model.barcode.request.BarcodeRequest;
import com.cdek.java.model.calculator.request.CalculatorRequest;
import com.cdek.java.model.courier.request.CourierRequest;
import com.cdek.java.model.invoice.request.InvoiceRequest;
import com.cdek.java.model.order.request.OrderRequest;

public interface ValidationService {

  void validateOrderRequest(OrderRequest orderRequest) throws CdekProxyException;

  void validateCourierRequest(CourierRequest courierRequest) throws CdekProxyException;

  void validateCalculatorRequest(CalculatorRequest calculatorRequest) throws CdekProxyException;

  void validateInvoiceRequest(InvoiceRequest invoiceRequest) throws CdekProxyException;

  void validateBarcodeRequest(BarcodeRequest barcodeRequest) throws CdekProxyException;

}
