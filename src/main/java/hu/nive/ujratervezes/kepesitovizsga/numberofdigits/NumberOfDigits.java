package hu.nive.ujratervezes.kepesitovizsga.numberofdigits;

public class NumberOfDigits {


    public int getNumberOfDigits(int i) {
        int result = 0;

        for (int g = 1; g <= i; g++) {
            char[] number = Integer.toString(g).toCharArray();
            result += number.length;
        }
        return result;
    }
}
