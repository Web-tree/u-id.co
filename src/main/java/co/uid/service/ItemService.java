package co.uid.service;

import co.uid.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import co.uid.model.Item;
import org.springframework.stereotype.Service;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 13:39
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Long save(Item item) {
        item = repository.save(item);
        return item.getId();
    }

    public Item getItem(Long id) {
        return repository.findOne(id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
