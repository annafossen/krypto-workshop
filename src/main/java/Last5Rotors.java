import java.util.ArrayList;
import java.util.Arrays;

public class Last5Rotors {

    private final ArrayList<Rotor> last5Rotors = new ArrayList<>(Arrays.asList(new Rotor(), new Rotor(), new Rotor(), new Rotor(), new Rotor()));

    public Last5Rotors() {

    }

    public ArrayList<Rotor> getRotors() {
        return last5Rotors;
    }

    public Rotor getRotorFromIndex(int index) {
        return last5Rotors.get(index);
    }

    public void setRotor(int index, Rotor rotor) {
        last5Rotors.set(index, rotor);
    }
}
