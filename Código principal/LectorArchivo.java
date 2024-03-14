import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class LectorArchivo {
    private String rutaArchivo;

    public LectorArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void leerYGuardarEstudiantes(Map<String, Estudiante> mapaEstudiantes, HashFunctionFactory factory) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String nombre = partes[0];
                    String telefono = partes[1];
                    String email = partes[2];
                    String postalZip = partes[3];
                    String country = partes[4];

                    HashFunction hashFunction = factory.getHashFunction();
                    String key = hashFunction.hash(email);

                    Estudiante estudiante = new Estudiante(nombre, telefono, email, postalZip, country);
                    mapaEstudiantes.put(key, estudiante);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
