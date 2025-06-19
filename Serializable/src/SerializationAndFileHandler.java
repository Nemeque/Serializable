import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que demuestra el uso de Serializable y operaciones con archivos
 */
public class SerializationAndFileHandler {
    // Constantes para los nombres de archivos
    private static final String SERIALIZED_FILE = "personas.ser";
    private static final String TEXT_FILE = "personas.txt";

    public static void main(String[] args) {
        try {
        // 1. Crear todas las listas
        List<Person> todasLasPersonas = new ArrayList<>();
        todasLasPersonas.addAll(createSamplePeople());       // Personas normales
        todasLasPersonas.addAll(createSampleProfesores());   // Profesores
        todasLasPersonas.addAll(createSampleEstudiantes());  // Estudiantes

        // 2. Escribir TODO en el archivo (sobrescribiendo)
        writeToFile(todasLasPersonas, TEXT_FILE);

        // 3. Leer el archivo para verificar
        System.out.println("\nContenido del archivo:");
        readFromFile(TEXT_FILE);

    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}

    /**
     * Crea una lista de ejemplo de personas
     * @return Lista de personas de ejemplo
     */
    private static List<Person> createSamplePeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Juan Pérez"));
        return people;
    }
        private static List<Person> createSampleProfesores() {
        List<Person> profesores = new ArrayList<>();
        profesores.add(new Profesor("María García"));
        return profesores;
        }
            private static List<Person> createSampleEstudiantes() {
        List<Person> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Daniel Sanchez"));
        return estudiantes;
            }
    /**
     * Procesa la lista de personas realizando todas las operaciones necesarias
     * @param people Lista de personas a procesar
     */
    private static void processPeople(List<Person> people) throws IOException, ClassNotFoundException {
        // 1. Serialización y deserialización
        System.out.println("=== Proceso de Serialización ===");
        serializeAndDeserialize(people);

        // 2. Operaciones con archivos de texto
        System.out.println("\n=== Operaciones con Archivos de Texto ===");
        handleTextFileOperations(people);
    }

    /**
     * Realiza el proceso de serialización y deserialización
     * @param people Lista de personas a procesar
     */
    private static void serializeAndDeserialize(List<Person> people) throws IOException, ClassNotFoundException {
        // Serializar
        System.out.println("Serializando objetos...");
        serializeObjects(people, SERIALIZED_FILE);
        
        // Deserializar
        System.out.println("\nDeserializando objetos...");
        List<Person> deserializedPeople = deserializeObjects(SERIALIZED_FILE);
        System.out.println("Objetos deserializados:");
        for (Person person : deserializedPeople) {
            System.out.println(person);
        }
    }

    /**
     * Maneja las operaciones con archivos de texto
     * @param people Lista de personas a procesar
     */
    private static void handleTextFileOperations(List<Person> people) throws IOException {
        // Escribir en archivo
        System.out.println("Escribiendo en archivo de texto...");
        writeToFile(people, TEXT_FILE);
        
        // Leer archivo
        System.out.println("\nLeyendo archivo de texto con BufferedReader...");
        readFromFile(TEXT_FILE);
    }

    /**
     * Serializa una lista de objetos Person a un archivo
     * @param people Lista de personas a serializar
     * @param filename Nombre del archivo donde se guardará
     */
    private static void serializeObjects(List<Person> people, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
            System.out.println("Objetos serializados exitosamente en " + filename);
        }
    }

    /**
     * Deserializa una lista de objetos Person desde un archivo
     * @param filename Nombre del archivo a leer
     * @return Lista de personas deserializadas
     */
    @SuppressWarnings("unchecked")
    private static List<Person> deserializeObjects(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Person>) ois.readObject();
        }
    }

    /**
     * Escribe la información de las personas en un archivo de texto
     * @param people Lista de personas a escribir
     * @param filename Nombre del archivo donde se escribirá
     */
    private static void writeToFile(List<Person> people, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person person : people) {
                writer.write(person.toString());
                writer.newLine();
            }
            System.out.println("Archivo de texto creado exitosamente: " + filename);

        }
    }

    /**
     * Lee el contenido de un archivo de texto usando BufferedReader
     * @param filename Nombre del archivo a leer
     */
    private static void readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contenido del archivo:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
} 