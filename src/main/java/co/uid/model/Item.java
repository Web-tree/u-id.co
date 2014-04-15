package co.uid.model;

/**
 * @author Max Levicky
 *         Date: 29.03.2014
 *         Time: 12:21
 */
public interface Item extends Model {
    public Long getId();

    public void setId(Long id);

    public String getEncodedId();

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);
}