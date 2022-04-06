import java.util.ArrayList;
import java.util.Arrays;

public class PlugBits {

    private final ArrayList<ArrayList<Integer>> plugBits;

    public PlugBits(){
        plugBits = fillPlugBitsEmpty();
    }

    private ArrayList<ArrayList<Integer>> fillPlugBitsEmpty(){
        ArrayList<ArrayList<Integer>> bits = new ArrayList<>();
        for(int i=0; i<1274; i++){
            ArrayList<Integer> temp1 = new ArrayList<>();
            for(int j=0; j<5; j++){
                temp1.add(2);
            }
            bits.add(temp1);
        }
        return bits;
    }

    public int size() {
        return plugBits.size();
    }

    public ArrayList<Integer> get(int index) {
        return plugBits.get(index);
    }

    //TODO: Oppgave 1
    public void fillBitsFromAllZeroOrAllOne(ArrayList<Integer> ct){
        for(int i=0; i<ct.size(); i++){
            //TODO: Finn tallet som tilsvarer (0,0,0,0,0) i klassen CCITT2Numbers.java
            /*if(ct.get(i) == #SKRIV INN HER#){
                ArrayList<Integer> result = xor(CCITT2Numbers.getN32(), CCITT2Alphabet.getAlphabet().get(i%26));
                plugBits.set(i, result);
            }*/
            //TODO: Finn tallet som tilsvarer (1,1,1,1,1) i klassen CCITT2Numbers.java
            /*if(ct.get(i) == #SKRIV INN HER#){
                ArrayList<Integer> result = xor(CCITT2Numbers.getN29(), CCITT2Alphabet.getAlphabet().get(i%26));
                plugBits.set(i, result);
            }*/
        }
    }

    //TODO: Oppgave 2
    public void loopToFindRotors(Rotors rotors, First5Rotors first5Rotors){
        for (Rotor rotor : rotors.getRotors()) {
            int period = rotor.getWheel().size();
            ArrayList<Integer> not = new ArrayList<>(Arrays.asList(2,2,2,2,2));
            for(int i=0; i<5; i++){
                for(int j=0; j<plugBits.size(); j++){
                    if(plugBits.get(j).get(i) != 2){
                        int numPeriods = 1;
                        while(numPeriods < 28){
                            //TODO: Finn den neste posisjonen (nextPos) ved å bruke størrelsen på rotoren
                            int nextPos = 0; //Bytt ut "0" her
                            if(nextPos < plugBits.size()){
                                if(plugBits.get(nextPos).get(i) != 2){
                                    if(!plugBits.get(nextPos).get(i).equals(plugBits.get(j).get(i))){
                                        not.set(i, 1);
                                    }
                                }
                            }
                            numPeriods++;
                        }
                    }
                }
            }
            if(not.contains(2)){
                int index = 0;
                for(int i=0; i<not.size(); i++){
                    if(not.get(i) == 2){index = i; }
                }
                first5Rotors.setRotor(index, rotors.getRotorFromPeriod(period));
            }
        }
    }
    //TODO: Oppgave 3
    public void regeneratePlugBits(First5Rotors first5Rotors, ArrayList<ArrayList<Integer>> ctBits){
        //TODO: Fyll inn rotorene med bit ved hjelp av metoden "fillInRotorsAndBits" med riktige parametre på den åpne linjen under

        int index = 0;
        while(index<3){
            for(int i=0; i<plugBits.size(); i++){
                if(oneEmptyBit(plugBits.get(i))){
                    findLastPlugBit(i, plugBits.get(i), ctBits.get(i));
                }
            }
            fillRotorsAndBits(first5Rotors.getRotors(), plugBits);
            index++;
        }
    }

    private ArrayList<Integer> xor(ArrayList<Integer> one, ArrayList<Integer> two){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<5; i++){
            int num1 = one.get(i);
            int num2 = two.get(i);
            result.add(num1^num2);
        }
        return result;
    }

    private void fillRotorsAndBits(ArrayList<Rotor> rotorList, ArrayList<ArrayList<Integer>> list){
        for(int i=0; i<rotorList.size(); i++){
            fillInRotor(i, rotorList.get(i), list);
            fillInFromRotor(i, rotorList.get(i), list);
        }
    }

    private void fillInRotor(int bit, Rotor rotor, ArrayList<ArrayList<Integer>> list){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).get(bit) != 2){
                if(rotor.getWheel().get(i%rotor.getWheel().size()) == 2){
                    rotor.getWheel().set(i%rotor.getWheel().size(), list.get(i).get(bit));
                }
            }
        }
    }

    private void fillInFromRotor(int bit, Rotor rotor, ArrayList<ArrayList<Integer>> list){
        for(int i=0; i<list.size(); i++){
            if(rotor.getWheel().get(i%rotor.getWheel().size()) != 2){
                if(list.get(i).get(bit) == 2){
                    list.get(i).set(bit, rotor.getWheel().get(i%rotor.getWheel().size()));
                }
            }
        }
    }

    private void findLastPlugBit(int listPos, ArrayList<Integer> list1, ArrayList<Integer> list2){
        int count1 = 0;
        int count2 = 0;
        int pos = 0;
        for(int i=0; i<list1.size(); i++){
            if(list1.get(i) == 2){
                pos = i;
                if(list2.get(i) == 1){count2++;}
            }
            else{
                int xored = CCITT2Alphabet.getAlphabet().get(listPos%26).get(i)^list1.get(i);
                if(xored == 1){count1++;}
                if(list2.get(i) == 1){count2++;}
            }
        }

        if(count1<count2){
            if(CCITT2Alphabet.getAlphabet().get(listPos%26).get(pos) == 1){list1.set(pos, 0);}
            else{list1.set(pos, 1);}
        }
        else{
            if(CCITT2Alphabet.getAlphabet().get(listPos%26).get(pos) == 0){list1.set(pos, 0);}
            else{list1.set(pos, 1);}
        }
    }

    private boolean oneEmptyBit(ArrayList<Integer> list){
        int count = 0;
        for (Integer integer : list) {
            if (integer == 2) {
                count++;
            }
        }
        return count == 1;
    }
}
