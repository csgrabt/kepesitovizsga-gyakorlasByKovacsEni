package hu.nive.ujratervezes.kepesitovizsga.covid;

import java.util.Comparator;

public class PersonComparatorToPfizer implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int value1 = o1.getPregnant().compareTo(o2.getPregnant());
        if (value1 == 0) {
            if (o1.getPregnant() == Pregnancy.IGEN && o2.getPregnant() == Pregnancy.IGEN) {
                return o1.getRegNumber() - o2.getRegNumber();
            }
            if (o1.getAge() > 65 && o2.getAge() > 65) {
                return o1.getRegNumber() - o2.getRegNumber();
            } else if (o1.getAge() > 65 || o2.getAge() > 65) {
                return o2.getAge() - o1.getAge();
            } else {
                return o1.getRegNumber() - o2.getRegNumber();
            }
        }

        return value1;
    }
}

