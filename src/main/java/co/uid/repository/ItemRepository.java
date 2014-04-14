package co.uid.repository;

import co.uid.model.ItemImpl;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author Maxim Levicky
 */
public interface ItemRepository extends GraphRepository<ItemImpl> {

}
