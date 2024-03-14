import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SHA1HashTest {

    @Test
    void testSHA1Hash() {
        HashFunction hashFunction = new SHA1Hash();
        String data = "test";
        assertEquals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", hashFunction.hash(data));
    }
}
