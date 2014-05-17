package co.uid.controller;

import co.uid.model.Item;
import co.uid.model.ItemImpl;
import co.uid.service.ItemService;
import co.uid.system.FacesHelper;
import co.uid.utils.IdEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

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

    private ItemImpl item = new ItemImpl();

    public void saveItem() {
        itemService.save(item);
        FacesHelper.addMessageWithRedirect("Item " + item.getName() + " added");
        FacesHelper.redirect("/" + item.getEncodedId());
        clearItem();
    }

    public Item getItemByEncodedId(String encodedId) {
        return itemService.getItem(IdEncoder.decodeId(encodedId));
    }

    public Page<ItemImpl> getItems() {
        return itemService.getItems(new PageRequest(0, 10));
    }

    public Item getItem() {
        return item;
    }

    public void setItem(ItemImpl item) {
        this.item = item;
    }

    private void clearItem() {
        item = new ItemImpl();
    }
}
