package co.uid.service;

import co.uid.model.ItemImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Maxim Levicky
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ContextConfiguration(locations = {"classpath*:/co/uid/spring/*.xml"})
public class ItemServiceTest {
    @Autowired
    private ItemService service;
    @Test
    public void testCRUD() throws Exception {
        ItemImpl item = new ItemImpl();
        String name = "item name example";
        item.setName(name);

        Long id = service.save(item);
        assertNotNull(id);

        assertEquals(name, item.getName());
        assertEquals(name, service.getItem(id).getName());

        String newName = "new test name";
        item.setName(newName);

        service.save(item);

        assertEquals(newName, item.getName());
        assertEquals(newName, service.getItem(id).getName());

        service.delete(id);

        assertNull(service.getItem(id));
    }

    @Test
    public void testDeleteNode() throws Exception {

    }
}
