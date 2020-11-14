package ru.isf.mortgage.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.isf.mortgage.controller.dto.RequestDto;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для валидации заявки
 */
@Component
public class RequestDtoValidator {
    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(RequestDtoValidator.class.getName());

    public RequestDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(RequestDto requestDto) {
        if (requestDto.getClientFullName().isEmpty()) {
            logger.error("client's is empty");
            String message = messageSource.getMessage("clientname.empty", new Object[]{}, Locale.getDefault());
            throw new IllegalArgumentException(message);
        } else if (!validateCyrillic(requestDto.getClientFullName())) {
            logger.error("Имя клиента должно быть написано кириллицей");
            throw new RuntimeException("имя клиента написано не кириллицей");
        }
    }

    /**
     * Проверяет строку на кириллицу
     * @param str
     * @return
     */
    private boolean validateCyrillic(String str) {
        String regex = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
}
