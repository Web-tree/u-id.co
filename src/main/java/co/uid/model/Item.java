package co.uid.model;

import org.springframework.data.neo4j.annotation.NodeEntity;

import javax.faces.bean.ManagedBean;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 12:21
 */
@NodeEntity
public interface Item extends Model {
    public Long getId();

    public void setId(Long id);

    public String getEncodedId();

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);
}