package com.admin.catalogo.domain.exceptions;

import java.util.List;
import com.admin.catalogo.domain.validation.Error;

public class DomainException extends RuntimeException {

    private final List<Error> errors;

    public DomainException(final List<Error> anErros) {
        super("", null, true, false);
        this.errors = anErros;
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException(anErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
