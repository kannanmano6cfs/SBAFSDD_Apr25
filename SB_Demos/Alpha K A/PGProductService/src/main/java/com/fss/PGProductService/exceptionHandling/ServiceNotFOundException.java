package com.fss.PGProductService.exceptionHandling;


public class ServiceNotFOundException extends RuntimeException {

    public ServiceNotFOundException(long id)
    {
        super("Service with id " + id + " not found");
    }
}
