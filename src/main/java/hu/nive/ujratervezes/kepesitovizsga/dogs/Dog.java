package hu.nive.ujratervezes.kepesitovizsga.dogs;

public class Dog {
    private String name;
    private String Country;
    private String Url;

    public Dog(String name, String country, String url) {
        this.name = name;
        Country = country;
        Url = url;
    }


    public String getName() {
        return name;
    }

    public String getCountry() {
        return Country;
    }

    public String getUrl() {
        return Url;
    }
}
