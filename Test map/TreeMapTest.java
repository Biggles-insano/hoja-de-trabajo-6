import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeMapTest {

    @Test
    void testTreeMap() {
        Map<String, String> map = new TreeMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        
        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
    }
}
