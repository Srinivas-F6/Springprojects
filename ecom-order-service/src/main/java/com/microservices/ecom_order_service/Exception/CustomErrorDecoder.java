package com.microservices.ecom_order_service.Exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder{
	@Override
	   public Exception decode(String methodKey, Response response) {
	     if (response.status() == 400)
	       throw new IllegalArgumentException("bad zone name");
	     return new ErrorDecoder.Default().decode(methodKey, response);
	   }
}
