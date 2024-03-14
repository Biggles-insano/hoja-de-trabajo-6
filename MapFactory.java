import java.util.Map;

public class MapFactory {
    public static Map<String, String> createMap(String mapType) {
        switch (mapType) {
            case "HashMap":
                return new HashMap<>();
            case "TreeMap":
                return new TreeMap<>();
            case "LinkedHashMap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de mapa no válido: " + mapType);
        }
    }
}
