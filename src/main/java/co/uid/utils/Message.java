package co.uid.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * User: maxim.levicky
 * Date: 9/26/13
 * Time: 6:13 PM
 */
@Component
public class Message {
    @Autowired
    private MessageSource messages;

    private Locale locale;


    public String getMessage(String message, Object[] args) {
        return messages.getMessage(message, args, getLocale());
    }
    public String getMessage(String message) {
        return getMessage(message, null);
    }

    private Locale getLocale() {
        if (locale == null) {
            locale = LocaleContextHolder.getLocale();
        }
        return locale;
    }
}
