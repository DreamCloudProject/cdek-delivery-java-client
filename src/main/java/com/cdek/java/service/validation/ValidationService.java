package com.cdek.java.service.validation;

import com.cdek.java.exception.CdekProxyException;
import com.cdek.java.model.order.request.OrderRequest;

public interface ValidationService {

  void validateOrder(OrderRequest orderRequest) throws CdekProxyException;

}
