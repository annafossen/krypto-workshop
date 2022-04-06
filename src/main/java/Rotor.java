import java.util.ArrayList;

public class Rotor{

    private ArrayList<Integer> rotorWheel;

    public Rotor() {

    }

    public Rotor(Integer size) {
        this.rotorWheel = fillRotorEmpty(size);
    }

    private ArrayList<Integer> fillRotorEmpty(Integer size) {
        ArrayList<Integer> rotorWheel = new ArrayList<>();
        for (int i=0; i<size; i++) {
            rotorWheel.add(2);
        }
        return rotorWheel;
    }

    public ArrayList<Integer> getWheel() {
        return rotorWheel;
    }
}
