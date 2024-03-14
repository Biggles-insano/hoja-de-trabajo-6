public class OrganicaHash implements HashFunction {
    @Override
    public String hash(String data) {
        return data; // Devuelve el mismo dato como llave
    }
}
