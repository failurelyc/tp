package seedu.address.model.util;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import seedu.address.model.entity.Entity;
import seedu.address.model.entity.EntityPathPair;

/**
 * Contains utility methods for populating {@code EntityReference} with sample data.
 */
public class SampleEntityUtil {

    private SampleEntityUtil() {} // Prevent instantiation

    /**
     * Returns a list of sample entities.
     */
    public static List<EntityPathPair> getSampleEntities() {
        List<EntityPathPair> entities = new ArrayList<>();
        entities.add(new EntityPathPair(new Entity("Ahri"), Path.of("/images/ahri.png")));
        entities.add(new EntityPathPair(new Entity("Garen"), Path.of("/images/garen.png")));
        entities.add(new EntityPathPair(new Entity("Lux"), Path.of("/images/lux.png")));
        entities.add(new EntityPathPair(new Entity("Ashe"), Path.of("/images/ashe.png")));
        entities.add(new EntityPathPair(new Entity("Jinx"), Path.of("/images/jinx.png")));
        entities.add(new EntityPathPair(new Entity("Yasuo"), Path.of("/images/yasuo.png")));
        entities.add(new EntityPathPair(new Entity("Lee Sin"), Path.of("/images/leesin.png")));
        entities.add(new EntityPathPair(new Entity("Thresh"), Path.of("/images/thresh.png")));

        return entities;
    }
}
