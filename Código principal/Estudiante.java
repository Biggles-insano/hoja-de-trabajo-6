import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estudiantes {
    private Map<Integer, Estudiante> estudiantes;
    private Scanner scanner;

    public Estudiantes() {
        this.estudiantes = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void agregarEstudianteDesdeConsola() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el código del estudiante: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Estudiante estudiante = new Estudiante(nombre, codigo);
        agregarEstudiante(estudiante);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getCodigo(), estudiante);
    }

    public Estudiante buscarPorCodigo(int codigo) {
        return estudiantes.get(codigo);
    }

    public static void main(String[] args) {
        Estudiantes estudiantes = new Estudiantes();

        // Agregar estudiantes desde la consola
        for (int i = 0; i < 2; i++) {
            System.out.println("Agregando estudiante #" + (i + 1));
            estudiantes.agregarEstudianteDesdeConsola();
        }

        // Buscar un estudiante por código
        System.out.print("Ingrese el código del estudiante a buscar: ");
        int codigoBusqueda = Integer.parseInt(estudiantes.scanner.nextLine());
        Estudiante encontrado = estudiantes.buscarPorCodigo(codigoBusqueda);
        System.out.println("Estudiante encontrado: " + encontrado);
    }
}

class Estudiante {
    private String nombre;
    private int codigo;

    public Estudiante(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
