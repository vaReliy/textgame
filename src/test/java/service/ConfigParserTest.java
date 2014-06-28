package service;

import model.Entity;
import org.junit.*;
import java.util.Set;
import static junit.framework.Assert.assertTrue;

public class ConfigParserTest {
    private Set<Entity> entitySet;
    private ConfigParser cp;


    @Before
    public void setUp(){
        cp = new ConfigParser();
        entitySet = cp.getGameContent();
    }

    @Test
    public void testGetGameContent() throws Exception {
        assertTrue(cp.isCreatedContent());
        cp.printContent();
    }
}