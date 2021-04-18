package hu.nive.ujratervezes.kepesitovizsga.covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.util.ArrayList;
import java.util.List;

public class SinoPharm extends Vaccine {
    public SinoPharm(MariaDbDataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Person> getVaccinationList() {
        List<Person> result = super.getVaccinationList();
        result.removeIf(person -> person.getPregnant().equals(Pregnancy.IGEN));
        result.removeIf(person -> person.getChronic().equals(ChronicDisease.IGEN));

        List<Person> resultShorted = new ArrayList<>();
        for (Person item : result
        ) {
            if (item.getAge() < OLD_PERSON) {
                resultShorted.add(item);
            }
        }
        result.removeIf(person -> person.getAge() < OLD_PERSON);

        resultShorted.addAll(result);


        return resultShorted;
    }
}
