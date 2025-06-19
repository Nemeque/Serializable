import java.io.Serializable;

/**
 * Clase Person que implementa la interfaz Serializable
 * Esta clase demuestra cómo hacer que un objeto sea serializable en Java
 */
public class Person implements Serializable, Deberes {
    // SerialVersionUID para control de versiones
    private static final long serialVersionUID = 1L;
    
    // Atributos de la clase
    protected String name;

    
    /**
     * Constructor de la clase Person
     * @param name Nombre de la persona
     */
    public Person(String name) {
        this.name = name;
    }
    
    // Getters y Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
        @Override
    public String deberes() {
        return "Deberes de Persona:\n" +
               "1. Respetar a los demás miembros de la institución\n" +
               "2. Cumplir con las normas establecidas\n" +
               "3. Mantener el orden y la limpieza";
    }
    
    /**
     * Método toString para mostrar la información de la persona
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}' + deberes();
    }
} 