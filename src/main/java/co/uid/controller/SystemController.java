package co.uid.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 12:05
 */
@ManagedBean(name = "systemController")
@SessionScoped
public class SystemController implements Serializable {
    private String messages;
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getItem(Model model) {
//        Item item = new ItemImpl();
//        model.addAttribute("item", item);
//        return "index";
//    }

    public String getMessages() {
        String result = messages;
        messages = "";
        return result;
    }

    public void addMessage(String message) {
        messages = message;
    }
}
