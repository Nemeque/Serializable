public class Profesor extends Person {
    private static final long serialVersionUID = 1L;
    private String materia;
    
    public Profesor(String name, String materia) {
       super(name);
       this.materia = materia;
    }
    
    public String getMateria() {
        return materia;
    }
    
    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    @Override
    public String deberes() {
        return "Deberes de Profesor:\n" +
               "1. Preparar las clases adecuadamente\n" +
               "2. Evaluar a los estudiantes de forma justa\n" +
               "3. Mantener actualizados sus conocimientos\n" +
               "4. Guiar y orientar a los estudiantes";
    }
    
    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + getName() + '\'' +
                ", materia='" + materia + '\'' +
                '}' + deberes();
    }
}