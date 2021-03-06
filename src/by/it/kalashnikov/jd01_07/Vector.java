package by.it.kalashnikov.jd01_07;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var{

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    Vector (Vector vector){
        this(vector.value);
    }


    Vector (String strVector){
        String [] strings = strVector
        .replace('{',' ').
        replace('}',' ').
        trim().
        split(",\\s*");
        double [] array = new double[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        this.value=array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
