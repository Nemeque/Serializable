import java.io.Serializable;

/**
 * Clase Person que implementa la interfaz Serializable
 * Esta clase demuestra cómo hacer que un objeto sea serializable en Java
 */
public class Profesor extends Person implements Serializable, Deberes {
    // SerialVersionUID para control de versiones
    private static final long serialVersionUID = 1L;
    
    public Profesor(String name) {
       super(name);
    }
    


        @Override
    public String deberes() {
        return "Deberes de Profesor:\n" +
               "1. Preparar las clases adecuadamente\n" +
               "2. Evaluar a los estudiantes de forma justa\n" +
               "3. Mantener actualizados sus conocimientos\n" +
               "4. Guiar y orientar a los estudiantes";
    }
    
    /**
     * Método toString para mostrar la información de la persona
     */
    @Override
    public String toString() {
        return "Profesor{" +
                "name='" + getName() + '\'' +
                '}' + deberes();
    }
}