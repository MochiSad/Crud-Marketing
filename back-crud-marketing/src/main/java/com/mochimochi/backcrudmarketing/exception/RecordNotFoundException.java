package com.mochimochi.backcrudmarketing.exception;

public class RecordNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(long id) {
        super("Registro não encontrado com o id: " + id);
    }

}
