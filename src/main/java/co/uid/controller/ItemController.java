package co.uid.controller;

import co.uid.model.Item;
import co.uid.model.ItemImpl;
import co.uid.service.ItemService;
import co.uid.system.FacesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * @author lucifer
 *         created 12.04.2014
 */
@Component
@ManagedBean
@SessionScoped
public class ItemController implements Serializable {
    @Autowired
    private ItemService itemService;

    private Item item = new ItemImpl();

    public void saveItem() {
        itemService.save(item);
        FacesHelper.addMessageWithRedirect("item added");
        FacesHelper.redirect("/item/add");
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
