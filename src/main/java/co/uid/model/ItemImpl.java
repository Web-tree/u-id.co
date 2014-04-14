package co.uid.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 12:21
 */
@NodeEntity
public class ItemImpl implements Item {
    @GraphId
    private Long id;

    @Indexed
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
