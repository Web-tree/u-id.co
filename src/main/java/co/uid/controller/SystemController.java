package co.uid.controller;

import co.uid.model.Item;
import co.uid.model.ItemImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 12:05
 */
@Controller
public class SystemController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getItem(Model model) {
        Item item = new ItemImpl();
        model.addAttribute("item", item);
        return "index";
    }
}
