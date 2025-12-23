package ir.shop.online.commons.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDto {
    private String code;
    private String paramName;
    private String message;
}