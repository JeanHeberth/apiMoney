package com.br.apimoney.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String messageUsuario = messageSource.getMessage("mensagem.invalida", null, request.getLocale());

        String messageDesenvolvedor = ex.getCause() != null ? ex.getCause().toString() : ex.toString();

        return handleExceptionInternal(ex, new Erro(messageUsuario, messageDesenvolvedor), headers, HttpStatus.BAD_REQUEST, request);
    }

    private static class Erro {

        private String messageUsuario;
        private String messageDesenvolvedor;

        public Erro(String messageUsuario, String messageDesenvolvedor) {
            this.messageUsuario = messageUsuario;
            this.messageDesenvolvedor = messageDesenvolvedor;
        }

        public String getMessageUsuario() {
            return messageUsuario;
        }

        public String getMessageDesenvolvedor() {
            return messageDesenvolvedor;
        }
    }
}
