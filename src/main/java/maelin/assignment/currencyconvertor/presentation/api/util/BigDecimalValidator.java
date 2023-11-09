package maelin.assignment.currencyconvertor.presentation.api.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import maelin.assignment.currencyconvertor.presentation.api.util.validator.NotBlankBigDecimal;

import java.math.BigDecimal;

public class BigDecimalValidator implements ConstraintValidator<NotBlankBigDecimal, BigDecimal> {
    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        return value != null;
    }
}
