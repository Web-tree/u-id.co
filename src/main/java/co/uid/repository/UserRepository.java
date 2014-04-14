package co.uid.repository;

import co.uid.model.User;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author Maxim Levicky
 */
public interface UserRepository extends GraphRepository<User> {
}
