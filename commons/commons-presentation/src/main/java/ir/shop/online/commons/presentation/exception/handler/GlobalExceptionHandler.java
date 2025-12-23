package ir.shop.online.commons.presentation.exception.handler;

import ir.shop.online.commons.domain.exception.DomainValidationException;
import ir.shop.online.commons.presentation.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainValidationException.class)
    public ResponseEntity<ErrorDto> handleDomainValidationException(DomainValidationException ex) {

        // اینجا می‌توانید بر اساس ex.getCode() پیغام مناسب را از فایل‌های Resource Bundle یا نقشه کدها پیدا کنید
        String errorMessage = translateCodeToMessage(ex.getCode());

        ErrorDto error = new ErrorDto(
                ex.getCode(),
                ex.getParamName(),
                errorMessage
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private String translateCodeToMessage(String code) {
        // منطق ترجمه کد به متن فارسی یا انگلیسی
        // مثال ساده:
        return "مقدار وارد شده برای این پارامتر نامعتبر است";
    }
}