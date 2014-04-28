package co.uid.repository;

import co.uid.model.Item;
import co.uid.model.ItemImpl;
import org.springframework.data.neo4j.repository.GraphRepository;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author Maxim Levicky
 */
@ApplicationScoped
public interface ItemRepository extends GraphRepository<Item> {

}
