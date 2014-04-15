package co.uid.service;

import co.uid.model.ItemImpl;
import co.uid.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import co.uid.model.Item;
import co.uid.model.ItemImpl;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 13:39
 */
@Service
@ManagedBean(name = "itemService")
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Long save(ItemImpl item) {
        item = repository.save(item);
        return item.getId();
    }

    public ItemImpl getItem(Long id) {
        return repository.findOne(id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
