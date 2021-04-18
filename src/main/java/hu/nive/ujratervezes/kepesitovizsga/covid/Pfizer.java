package hu.nive.ujratervezes.kepesitovizsga.covid;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pfizer extends Vaccine {


    public Pfizer(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Person> getVaccinationList() {
        List<Person> result = super.getVaccinationList();

        result.sort(new PersonComparatorToPfizer());
        return result;
    }

    //  @Override
    //  public List<Person> getVaccinationList() {
    //      List<Person> persons = super.getVaccinationList();

    //      List<Person> result = new ArrayList<>();
    //
    //      for (Person item : persons
    //      ) {
    //          if (item.getPregnant().equals(Pregnancy.IGEN)) {
    //              result.add(item);
    //          }
    //      }

    //      for (Person item : persons
    //      ) {
    //          if (item.getAge() > OLD_PERSON) {
    //              result.add(item);
    //          }

    //      }
    //      for (Person item : persons
    //      ) {
    //          if (!result.contains(item)) {
    //              result.add(item);
    //          }

    //      }


    //      return result;
    //  }
}

