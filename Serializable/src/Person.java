import java.io.Serializable;

public class Person implements Serializable, interfaz {

    private static final long serialVersionUID = 1L;
    

    protected String name;
    
    public Person(String name) {
        this.name = name;
    }
    
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
    
    
    @Override
    public String toString() {
        return "Person{" +
                "nombre='" + name + '\'' +
                '}' + deberes();
    }
} 