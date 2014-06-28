package service;

import model.Entity;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertTrue;

public class ConfigParserTest {
    private Map<Integer, Entity> entityMap;
    private ConfigParser cp;


    @Before
    public void setUp(){
        cp = new ConfigParser();
        entityMap = cp.getEntityMap();
        System.out.println("size: " + entityMap.size());
    }

    @Test
    public void testGetGameContent() throws Exception {
        assertTrue(cp.isCreatedContent());
        cp.printContent();

    }
}