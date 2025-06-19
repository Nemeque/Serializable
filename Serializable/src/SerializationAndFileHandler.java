import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationAndFileHandler {

    private static final String SERIALIZED_FILE = "personas.ser";
    private static final String TEXT_FILE = "registros.txt";

    public static void main(String[] args) {
        try {

        List<Person> todasLasPersonas = new ArrayList<>();
        todasLasPersonas.addAll(createSamplePeople());     
        todasLasPersonas.addAll(createSampleProfesores());   
        todasLasPersonas.addAll(createSampleEstudiantes()); 

        writeToFile(todasLasPersonas, TEXT_FILE);

        System.out.println("\nContenido del archivo:");
        readFromFile(TEXT_FILE);

    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}

    private static List<Person> createSamplePeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Juan Pérez"));
        return people;
    }
        private static List<Person> createSampleProfesores() {
        List<Person> profesores = new ArrayList<>();
        profesores.add(new Profesor("María García","programacion"));
        return profesores;
        }
            private static List<Person> createSampleEstudiantes() {
        List<Person> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Daniel Sanchez","cuarto"));
        return estudiantes;
            }

    private static void processPeople(List<Person> people) throws IOException, ClassNotFoundException {

        System.out.println("=== Proceso de Serialización ===");
        serializeAndDeserialize(people);

        System.out.println("\n=== Operaciones con Archivos de Texto ===");
        handleTextFileOperations(people);
    }

    private static void serializeAndDeserialize(List<Person> people) throws IOException, ClassNotFoundException {

        System.out.println("Serializando objetos...");
        serializeObjects(people, SERIALIZED_FILE);

        System.out.println("\nDeserializando objetos...");
        List<Person> deserializedPeople = deserializeObjects(SERIALIZED_FILE);
        System.out.println("Objetos deserializados:");
        for (Person person : deserializedPeople) {
            System.out.println(person);
        }
    }

    private static void handleTextFileOperations(List<Person> people) throws IOException {

        System.out.println("Escribiendo en archivo de texto...");
        writeToFile(people, TEXT_FILE);

        System.out.println("\nLeyendo archivo de texto con BufferedReader...");
        readFromFile(TEXT_FILE);
    }

    private static void serializeObjects(List<Person> people, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
            System.out.println("Objetos serializados exitosamente en " + filename);
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Person> deserializeObjects(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Person>) ois.readObject();
        }
    }

    private static void writeToFile(List<Person> people, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person person : people) {
                writer.write(person.toString());
                writer.newLine();
            }
            System.out.println("Archivo de texto creado exitosamente: " + filename);

        }
    }

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