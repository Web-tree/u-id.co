package co.uid.service;

import co.uid.model.ItemImpl;
import co.uid.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import co.uid.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 13:39
 */
@Service
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

    public Page<ItemImpl> getItems(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
