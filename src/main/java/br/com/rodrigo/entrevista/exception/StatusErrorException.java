package br.com.rodrigo.entrevista.exception;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

public class StatusErrorException extends ClientErrorException {


    public StatusErrorException(String message, Response.Status status) {
        super(message, status);
    }
}
