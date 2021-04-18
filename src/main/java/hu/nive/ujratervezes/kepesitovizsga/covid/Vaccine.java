package hu.nive.ujratervezes.kepesitovizsga.covid;


import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Vaccine {
    public static final int OLD_PERSON = 65;
    List<Person> persons;

    public Vaccine(DataSource dataSource) {
        this.persons = dataFromDatabase(dataSource);
    }

    private List<Person> dataFromDatabase(DataSource dataSource) {
        List<Person> persons = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * from registrations")) {
            try (ResultSet rs = ps.executeQuery()) {
                int regNumber = 1;
                while (rs.next()) {
                    String name = rs.getString("person_name");
                    int age = Integer.parseInt(rs.getString("age"));
                    String chronicDisease = rs.getString("chronic_disease");
                    String pregnancy = rs.getString("pregnancy");
                    persons.add(new Person(name, age, chronicDisease, pregnancy, regNumber));
                    regNumber++;
                }
                return persons;
            } catch (SQLException sql) {
                throw new IllegalArgumentException("Error by request", sql);
            }


        } catch (SQLException sql) {
            throw new IllegalArgumentException("Something went wrong!", sql);
        }


    }


    public List<Person> getVaccinationList() {
        List<Person> copyOfPersons = new ArrayList<>();

        for (Person item : persons
        ) {
            copyOfPersons.add(new Person(item));
        }
        return copyOfPersons;
    }

    public static void main(String[] args) throws SQLException {
        MariaDbDataSource dataSource;
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Vaccine vaccine = new Vaccine(dataSource);


        System.out.println(vaccine.getVaccinationList());

    }


}
