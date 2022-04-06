import java.util.ArrayList;
import java.util.Arrays;

public class First5Rotors {

    private final ArrayList<Rotor> first5Rotors = new ArrayList<>(Arrays.asList(new Rotor(), new Rotor(), new Rotor(), new Rotor(), new Rotor()));

    public First5Rotors() {

    }

    public ArrayList<Rotor> getRotors() {
        return first5Rotors;
    }

    public Rotor getRotorFromIndex(int index) {
        return first5Rotors.get(index);
    }

    public void setRotor(int index, Rotor rotor) {
        first5Rotors.set(index, rotor);
    }
}
