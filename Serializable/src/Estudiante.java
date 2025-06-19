import java.io.Serializable;

/**
 * Clase Person que implementa la interfaz Serializable
 * Esta clase demuestra cómo hacer que un objeto sea serializable en Java
 */
public class Estudiante extends Person implements Serializable, Deberes {
    // SerialVersionUID para control de versiones
    private static final long serialVersionUID = 1L;
    /**
     * Constructor de la clase Person
     * @param name Nombre de la persona
     */
    public Estudiante(String name) {
        super(name);
    }
        @Override
    public String deberes() {
        return "Deberes de Estudiante:\n" +
               "1. Asistir puntualmente a clases\n" +
               "2. Realizar las tareas asignadas\n" +
               "3. Estudiar para las evaluaciones\n" +
               "4. Respetar a profesores y compañeros";
    }
    
    /**
     * Método toString para mostrar la información de la persona
     */
    @Override
    public String toString() {
        return "Estudiante{" +
                "name='" + getName() + '\'' +
                '}' + deberes();
    }
}