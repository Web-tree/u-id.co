package co.uid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lucifer
 *         created 12.04.2014
 */
@Controller
public class ItemController {
    @RequestMapping(value = "/item/add", method = RequestMethod.GET)
    public String addItemPage() {
        return "item/add";
    }
}
