package hu.nive.ujratervezes.kepesitovizsga.dogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DogManager {


    private List<Dog> dogsFromFile() {
        List<Dog> dogs = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(DogManager.class.getResourceAsStream("/dogs.csv"))))) {
            String line;
            bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] array = line.split(";");
                dogs.add(new Dog(
                        array[1].toUpperCase(),
                        array[4].toUpperCase(),
                        array[5]
                ));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return dogs;

    }


    public List<Dog> getDogsInAlphabeticalOrderByName() {
        List<Dog> dogs = dogsFromFile();

        dogs.sort(Comparator.comparing(Dog::getName));

        return dogs;
    }


    public String getCountryByExactDogSpecies(String string) {
        List<Dog> dogs = dogsFromFile();

        for (Dog item : dogs
        ) {
            if (item.getName().equalsIgnoreCase(string)) {
                return item.getCountry();
            }

        }
        throw new IllegalArgumentException("No such dog name found.");
    }


    public Map<String, Integer> getDogStatistics() {
        Map<String, Integer> result = new HashMap<>();

        for (Dog item : dogsFromFile()
        ) {
            if (!result.containsKey(item.getCountry())) {
                result.put(item.getCountry(), 1);

            } else {
                result.put(item.getCountry(), result.get(item.getCountry()) + 1);
            }

        }
        return result;
    }


}
