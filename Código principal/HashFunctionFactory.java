public class HashFunctionFactory {
    public static HashFunction createHashFunction(String hashType) {
        switch (hashType) {
            case "Organica":
                return new OrganicaHash();
            case "MD5":
                return new MD5Hash();
            case "SHA-1":
                return new SHA1Hash();
            default:
                throw new IllegalArgumentException("Tipo de hash invalido" + hashType);
        }
    }
}
