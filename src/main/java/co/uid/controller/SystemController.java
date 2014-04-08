package co.uid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 12:05
 */
@Controller
public class SystemController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getItem() {
        return "co.uid.main";

    }
}
