package co.uid.model;

import co.uid.utils.FaceContext;
import co.uid.utils.IdEncoder;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import javax.faces.bean.ManagedBean;


/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 12:21
 */
@NodeEntity
public class ItemImpl implements Item {
    @GraphId
    private Long id;

//    @Indexed
    private String name;

//    @Indexed
    private String description;

    public ItemImpl() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncodedId() {
        return IdEncoder.encodeId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void add() {
        String qwe = FaceContext.getRequestParam("");
    }

}
