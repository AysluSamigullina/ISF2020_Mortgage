package ru.isf.mortgage.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.controller.dto.ResponseError;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для валидации заявки
 */
@Component
public class RequestDtoValidator {
    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(RequestDtoValidator.class.getName());

    public static List<ResponseError> errorList = new ArrayList<>();

    public RequestDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Валидация заявки
     * @param requestDto модель заявки
     */
    public void validate(RequestDto requestDto){
        if (requestDto.getClientFullName().isEmpty()) {
            logger.error("client's is empty");
            String message = messageSource.getMessage("clientname.empty", new Object[]{}, Locale.getDefault());
            errorList.add(new ResponseError(UUID.randomUUID(), message, new IllegalArgumentException().getMessage(), "my-system"));
        }
        if (!requestDto.getClientFullName().isEmpty() && !validateCyrillic(requestDto.getClientFullName())) {
            logger.error("Имя клиента должно быть написано кириллицей");
            errorList.add(new ResponseError(UUID.randomUUID(), "имя клиента написано не кириллицей", new RuntimeException().getMessage(), "my_system"));
        }
        if (requestDto.getSum().compareTo(BigDecimal.ZERO) == 0) {
            errorList.add(new ResponseError(UUID.randomUUID(), "заявленная сумма должна быть больше 0", new NumberFormatException().getMessage(), "my_system"));
        }
        if (!errorList.isEmpty()) {
            throw new RuntimeException("есть ошибки");
        }
    }

    /**
     * Проверяет строку на кириллицу
     * @param str строка с параметром из dto
     * @return  true, если валидация на кириллицу пройдена; false, если валидация не пройдена
     */
    private boolean validateCyrillic(String str) {
        String regex = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
}
