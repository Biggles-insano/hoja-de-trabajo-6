import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MD5HashTest {

    @Test
    void testMD5Hash() {
        HashFunction hashFunction = new MD5Hash();
        String data = "test";
        assertEquals("098f6bcd4621d373cade4e832627b4f6", hashFunction.hash(data));
    }
}
