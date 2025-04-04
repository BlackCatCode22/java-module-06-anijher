import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Animal {
    private String uniqueID;
    private String name;
    private LocalDate birthDate;
    private String species;
    private String color;
    private String sex;
    private double weight;
    private String habitat;
    private static int hyenaCount = 0, lionCount = 0; // Add counts for other species as needed.

    public Animal(String species, String color, String sex, double weight, int age) {
        this.species = species;
        this.color = color;
        this.sex = sex;
        this.weight = weight;
        this.birthDate = genBirthDay(age);
        this.uniqueID = genUniqueID(species);
    }

    public LocalDate genBirthDay(int age) {
        LocalDate today = LocalDate.now();
        return today.minusYears(age);
    }

    public String genUniqueID(String species) {
        switch (species.toLowerCase()) {
            case "hyena":
                hyenaCount++;
                return "Hy" + String.format("%02d", hyenaCount);
            case "lion":
                lionCount++;
                return "Li" + String.format("%02d", lionCount);
            // Add cases for other species.
            default:
                return species.substring(0, 2).toUpperCase() + "01";
        }
    }

    // Getters and setters omitted for brevity.
}
