package hu.nive.ujratervezes.kepesitovizsga.covid;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private ChronicDisease chronic;
    private Pregnancy pregnant;
    private int regNumber;

    public Person(String name, int age, String chronic, String pregnant, int regNumber) {
        this.name = name;
        this.age = age;
        this.chronic = chronicDisease(chronic);
        this.pregnant = pregnant(pregnant);
        this.regNumber = regNumber;
    }

    public Person(Person person) {
        this.name = person.getName();
        this.age = person.getAge();
        this.chronic = person.getChronic();
        this.pregnant = person.getPregnant();
        this.regNumber = person.getRegNumber();
    }

    public int getRegNumber() {
        return this.regNumber;
    }

    private Pregnancy pregnant(String pregnant) {
        if (pregnant.equalsIgnoreCase("igen")) {
            return Pregnancy.IGEN;
        }
        return Pregnancy.NEM;
    }

    private ChronicDisease chronicDisease(String string) {
        if (string.equalsIgnoreCase("igen")) {
            return ChronicDisease.IGEN;
        }
        return ChronicDisease.NEM;
    }

    public int getAge() {
        return age;
    }

    public ChronicDisease getChronic() {
        return chronic;
    }

    public Pregnancy getPregnant() {
        return pregnant;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && chronic == person.chronic && pregnant == person.pregnant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, chronic, pregnant);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
