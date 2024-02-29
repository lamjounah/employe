package com.example.emsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.PublicKey;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption  extends RuntimeException {
    public ResourceNotFoundExeption(String message){
        super(message);
    }
}
