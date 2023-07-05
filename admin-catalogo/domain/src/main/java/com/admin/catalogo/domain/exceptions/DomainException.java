package com.admin.catalogo.domain.exceptions;

import java.util.List;
import com.admin.catalogo.domain.validation.Error;

// construtor de RuntimeException, impacta a performance.. logar toda a stack trace
public class DomainException extends NoStackTraceException {

    private final List<Error> errors;

    public DomainException(final String aMessage, final List<Error> anErros) {
        super(aMessage);
        this.errors = anErros;
    }

    public static DomainException with(final Error anError) {
        throw new DomainException(anError.message(), List.of(anError));
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException("", anErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
