package com.dmolina.authorizeservice.error.exception;

public class NewUserWithDifferentPasswordsException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -7978601526802035152L;

    public NewUserWithDifferentPasswordsException() {
        super("Las contraseñas no coinciden");
    }




}