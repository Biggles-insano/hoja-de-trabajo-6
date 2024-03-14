import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Estudiantes {
    private Map<String, List<Estudiante>> estudiantesPorNacionalidad;
    private Scanner scanner;

    public Estudiantes() {
        this.estudiantesPorNacionalidad = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void agregarEstudianteDesdeConsola() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el teléfono del estudiante: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese el correo electrónico del estudiante: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese el código postal del estudiante: ");
        String postalZip = scanner.nextLine();

        System.out.print("Ingrese el país del estudiante: ");
        String country = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, telefono, email, postalZip, country);
        agregarEstudiante(estudiante);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        String nacionalidad = estudiante.getCountry();
        List<Estudiante> estudiantes = estudiantesPorNacionalidad.computeIfAbsent(nacionalidad, k -> new ArrayList<>());
        estudiantes.add(estudiante);
    }

    public Estudiante buscarPorEmail(String email) {
        for (List<Estudiante> listaEstudiantes : estudiantesPorNacionalidad.values()) {
            for (Estudiante estudiante : listaEstudiantes) {
                if (estudiante.getEmail().equals(email)) {
                    return estudiante;
                }
            }
        }
        return null;
    }

    public List<Estudiante> buscarPorNacionalidad(String nacionalidad) {
        return estudiantesPorNacionalidad.getOrDefault(nacionalidad, new ArrayList<>());
    }

    public static void main(String[] args) {
        Estudiantes estudiantes = new Estudiantes();

        // Agregar estudiantes desde la consola
        for (int i = 0; i < 2; i++) {
            System.out.println("Agregando estudiante #" + (i + 1));
            estudiantes.agregarEstudianteDesdeConsola();
        }

        // Buscar un estudiante por correo electrónico
        System.out.print("Ingrese el correo electrónico del estudiante a buscar: ");
        String emailBusqueda = estudiantes.scanner.nextLine();
        Estudiante encontrado = estudiantes.buscarPorEmail(emailBusqueda);
        if (encontrado != null) {
            System.out.println("Estudiante encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró ningún estudiante con ese correo electrónico.");
        }

        // Buscar estudiantes por nacionalidad
        System.out.print("Ingrese la nacionalidad de los estudiantes a buscar: ");
        String nacionalidadBusqueda = estudiantes.scanner.nextLine();
        List<Estudiante> encontrados = estudiantes.buscarPorNacionalidad(nacionalidadBusqueda);
        System.out.println("Estudiantes de " + nacionalidadBusqueda + ":");
        for (Estudiante estudiante : encontrados) {
            System.out.println(estudiante);
        }
    }
}

class Estudiante {
    private String nombre;
    private String telefono;
    private String email;
    private String postalZip;
    private String country;

    public Estudiante(String nombre, String telefono, String email, String postalZip, String country) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.postalZip = postalZip;
        this.country = country;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", postalZip='" + postalZip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
