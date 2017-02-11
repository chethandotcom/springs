package com.chethan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by chethanshetty on 11/02/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer Not Found")
public class CustomerNotFoundException extends RuntimeException {
}
