package com.admin.catalogo.domain.category;

import com.admin.catalogo.domain.validation.ValidationHandler;
import com.admin.catalogo.domain.validation.Validator;
import com.admin.catalogo.domain.validation.Error;

public class CategoryValidator extends Validator {

    private final Category category;

    protected CategoryValidator(final Category aCategory, final ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.category.getName();
        if (name == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error("'name' should not be empty"));
        }

        final int length = name.trim().length();
        if (length > 255 || length < 3) {
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }
    }
}
