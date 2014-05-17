package co.uid.repository;

import co.uid.model.Item;
import co.uid.model.ItemImpl;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * @author Maxim Levicky
 */
@ApplicationScoped
public interface ItemRepository extends GraphRepository<ItemImpl> {
}
