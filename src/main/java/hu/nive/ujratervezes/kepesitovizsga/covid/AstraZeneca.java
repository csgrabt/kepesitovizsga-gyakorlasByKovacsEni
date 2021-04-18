package hu.nive.ujratervezes.kepesitovizsga.covid;

import org.mariadb.jdbc.MariaDbDataSource;
import java.util.ArrayList;
import java.util.List;

public class AstraZeneca extends Vaccine {
    public AstraZeneca(MariaDbDataSource dataSource) {
        super(dataSource);
    }


    @Override
    public List<Person> getVaccinationList() {
        List<Person> persons = super.getVaccinationList();
        List<Person> result = new ArrayList<>();


        persons.removeIf(person -> person.getPregnant().equals(Pregnancy.IGEN));

        for (Person item : persons
        ) {
            if (item.getChronic().equals(ChronicDisease.IGEN)) {
                result.add(item);
            }
        }
        persons.removeIf(person -> person.getChronic().equals(ChronicDisease.IGEN));

        for (Person item : persons
        ) {
            if (item.getAge() > OLD_PERSON) {
                result.add(item);
            }
        }
        persons.removeIf(person -> person.getAge() > OLD_PERSON);
        result.addAll(persons);

        return result;
    }


}
