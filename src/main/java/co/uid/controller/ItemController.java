package co.uid.controller;

import co.uid.model.Item;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * @author lucifer
 *         created 12.04.2014
 */
@ManagedBean
@SessionScoped
public class ItemController implements Serializable {
    @ManagedProperty(value = "#{systemController}")
    private SystemController systemController;
    private String addResult = "unknown";
//    @RequestMapping(value = "/item/add", method = RequestMethod.GET)
//    public String addItemPage() {
//        return "item/add";
//    }
    public String addItem(Item item) {
        systemController.addMessage("Item added success");
        return "/item/addSuccess";
    }

    public SystemController getSystemController() {
        return systemController;
    }

    public void setSystemController(SystemController systemController) {
        this.systemController = systemController;
    }
}
