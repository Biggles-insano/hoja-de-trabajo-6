import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrganicaHashTest {

    @Test
    void testOrganicaHash() {
        HashFunction hashFunction = new OrganicaHash();
        String data = "test";
        assertEquals(data, hashFunction.hash(data));
    }
}
