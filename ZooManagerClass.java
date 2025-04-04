import java.io.*;
import java.util.*;

public class ZooManager {
    private List<Animal> animals = new ArrayList<>();

    public void loadAnimals(String arrivingAnimalsFile, String animalNamesFile) throws IOException {
        BufferedReader arrivingReader = new BufferedReader(new FileReader(arrivingAnimalsFile));
        BufferedReader namesReader = new BufferedReader(new FileReader(animalNamesFile));
        List<String> names = new ArrayList<>();
        String line;

        while ((line = namesReader.readLine()) != null) {
            names.add(line.trim());
        }

        int nameIndex = 0;
        while ((line = arrivingReader.readLine()) != null) {
            String[] data = line.split(", ");
            int age = Integer.parseInt(data[0].split(" ")[0]);
            String sex = data[1];
            String species = data[2];
            String color = data[4];
            double weight = Double.parseDouble(data[5].split(" ")[0]);

            Animal animal = new Animal(species, color, sex, weight, age);
            animal.setName(names.get(nameIndex++ % names.size()));
            animals.add(animal);
        }

        arrivingReader.close();
        namesReader.close();
    }

    public void generateReport(String outputFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        Map<String, List<Animal>> habitats = new HashMap<>();

        for (Animal animal : animals) {
            habitats.computeIfAbsent(animal.getSpecies() + " Habitat", k -> new ArrayList<>()).add(animal);
        }

        for (Map.Entry<String, List<Animal>> entry : habitats.entrySet()) {
            writer.write(entry.getKey() + ":\n");
            for (Animal animal : entry.getValue()) {
                writer.write(animal.toString() + "\n"); // Customize `toString` method in Animal class.
            }
            writer.write("\n");
        }

        writer.close();
    }
}
