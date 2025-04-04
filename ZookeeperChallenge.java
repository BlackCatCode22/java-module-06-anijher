import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.*;

public class ZookeeperChallenge {
    public class ZookeeperChallenge {
            public static void main(String[] args) {
                ZooManager manager = new ZooManager();
                try {
                    manager.loadAnimals("arrivingAnimals.txt", "animalNames.txt");
                    manager.generateReport("zooPopulation.txt");
                    System.out.println("Zoo population report generated!");
                } catch (IOException e) {
                    System.err.println("Error processing files: " + e.getMessage());

        }
    }
}