public class Estudiante extends Person {
    private static final long serialVersionUID = 1L;
    private String semestre;
    
    public Estudiante(String name, String semestre) {
       super(name);
       this.semestre = semestre;
    }
    
    public String getSemestre() {
        return semestre;
    }
    
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
        @Override
    public String deberes() {
        return "Deberes de Estudiante:\n" +
               "1. Asistir puntualmente a clases\n" +
               "2. Realizar las tareas asignadas\n" +
               "3. Estudiar para las evaluaciones\n" +
               "4. Respetar a profesores y compañeros";
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + getName() + '\'' +
                ", semestre='" + semestre + '\'' +
                '}' + deberes();
    }
}