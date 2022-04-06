import java.util.ArrayList;
import java.util.Arrays;

public class Rotors {

    private final Rotor r47 = new Rotor(47);
    private final Rotor r53 = new Rotor(53);
    private final Rotor r59 = new Rotor(59);
    private final Rotor r61 = new Rotor(61);
    private final Rotor r64 = new Rotor(64);
    private final Rotor r65 = new Rotor(65);
    private final Rotor r67 = new Rotor(67);
    private final Rotor r69 = new Rotor(69);
    private final Rotor r71 = new Rotor(71);
    private final Rotor r73 = new Rotor(73);

    private final ArrayList<Rotor> rotorList = new ArrayList<>(Arrays.asList(r47,r53,r59,r61,r64,r65,r67,r69,r71,r73));

    public Rotors() {

    }

    public ArrayList<Rotor> getRotors() {
        return rotorList;
    }

    public Rotor getRotorFromPeriod(int period){
        if(period == 47){return r47;}
        else if(period == 53){return r53;}
        else if(period == 59){return r59;}
        else if(period == 61){return r61;}
        else if(period == 64){return r64;}
        else if(period == 65){return r65;}
        else if(period == 67){return r67;}
        else if(period == 69){return r69;}
        else if(period == 71){return r71;}
        else{return r73;}
    }
}
