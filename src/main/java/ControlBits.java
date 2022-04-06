import java.util.ArrayList;
import java.util.Arrays;

public class ControlBits {

    private final ArrayList<ArrayList<Integer>> controlBits;

    public ControlBits(){
        controlBits = fillControlBitsEmpty();
    }

    private ArrayList<ArrayList<Integer>> fillControlBitsEmpty(){
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

    //TODO: Oppgave 5
    public void fillControlBitsFromWeight(ArrayList<ArrayList<Integer>> xored, ArrayList<ArrayList<Integer>> ctBits){
        for(int i=0; i<xored.size(); i++){
            if(countOnes(xored.get(i)) == 1){
                //TODO: Bruk metoden weightOne og legg til resultatet i listen "controlBits", med indeks i og
                // metoden du skal bruke som parametre. Her skal du bruke listene xored og ctBits til metoden
                // weightOne og hente på indeks i for hver av listene.

            }
            if(countOnes(xored.get(i)) == 4){
                //TODO: Bruk metoden weightFour og legg til resultatet i listen "controlBits", med indeks i og
                // metoden du skal bruke som parametre. Her skal du bruke listene xored og ctBits til metoden
                // weightOne og hente på indeks i for hver av listene.

            }
        }
    }

    public void loopToFindRotors(Rotors rotors, Last5Rotors last5Rotors){
        for (Rotor rotor : rotors.getRotors()) {
            int period = rotor.getWheel().size();
            ArrayList<Integer> not = new ArrayList<>(Arrays.asList(2,2,2,2,2));
            for(int i=0; i<5; i++){
                for(int j=0; j<controlBits.size(); j++){
                    if(controlBits.get(j).get(i) != 2){
                        int numPeriods = 1;
                        while(numPeriods < 28){
                            int nextPos = j + (period*numPeriods);
                            if(nextPos < controlBits.size()){
                                if(controlBits.get(nextPos).get(i) != 2){
                                    if(!controlBits.get(nextPos).get(i).equals(controlBits.get(j).get(i))){
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
                last5Rotors.setRotor(index, rotors.getRotorFromPeriod(period));
            }
        }
    }

    public void regenerateControlBits(Last5Rotors last5Rotors, ArrayList<ArrayList<Integer>> xored, ArrayList<ArrayList<Integer>> ctBits){
        fillRotorsAndBits(last5Rotors.getRotors(), controlBits);
        int index = 0;
        while(index<3){
            for(int i=0; i<controlBits.size(); i++){
                if(oneTwo(controlBits.get(i))){
                    tryOneBit(i, xored.get(i), controlBits.get(i), ctBits.get(i));
                }
            }
            fillRotorsAndBits(last5Rotors.getRotors(), controlBits);
            index++;
        }
    }

    private Integer countOnes(ArrayList<Integer> list){
        int count = 0;
        for (Integer integer : list) {
            if (integer == 1) {
                count++;
            }
        }
        return count;
    }

    private ArrayList<Integer> weightOne(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int pos1 = 0;
        int pos2 = 0;
        for(int i=0; i<list1.size(); i++){
            if(list1.get(i) == 1){pos1 = i;}
            if(list2.get(i) == 1){pos2 = i;}
        }

        if(pos1 == 0){
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(0, 0, 0, 1, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(0, 0, 1, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(0, 1, 2, 2, 2));}
        }
        else if(pos1 == 1){
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 2, 2, 1, 0));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 2, 2, 1, 1));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(2, 2, 2, 0, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
        }
        else if(pos1 == 2){
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 2, 1, 0, 0));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 2, 1, 0, 1));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(2, 2, 1, 1, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(2, 2, 0, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
        }
        else if(pos1 == 3){
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 1, 0, 0, 0));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 1, 0, 0, 1));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(2, 1, 0, 1, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(2, 1, 1, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(2, 0, 2, 2, 2));}
        }
        else{
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(1, 0, 0, 1, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(1, 0, 1, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(1, 1, 2, 2, 2));}
        }
    }

    private ArrayList<Integer> weightFour(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int pos1 = 0;
        int pos2 = 0;
        for(int i=0; i<list1.size(); i++){
            if(list1.get(i) == 0){pos1 = i;}
            if(list2.get(i) == 0){pos2 = i;}
        }

        if(pos1 == 0){
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(0, 0, 0, 1, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(0, 0, 1, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(0, 1, 2, 2, 2));}
        }
        else if(pos1 == 1){
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 2, 2, 1, 0));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 2, 2, 1, 1));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(2, 2, 2, 0, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
        }
        else if(pos1 == 2){
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 2, 1, 0, 0));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 2, 1, 0, 1));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(2, 2, 1, 1, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(2, 2, 0, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
        }
        else if(pos1 == 3){
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 1, 0, 0, 0));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 1, 0, 0, 1));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(2, 1, 0, 1, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(2, 1, 1, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(2, 0, 2, 2, 2));}
        }
        else{
            if(pos2 == 0){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else if(pos2 == 1){return new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));}
            else if(pos2 == 2){return new ArrayList<>(Arrays.asList(1, 0, 0, 1, 2));}
            else if(pos2 == 3){return new ArrayList<>(Arrays.asList(1, 0, 1, 2, 2));}
            else{return new ArrayList<>(Arrays.asList(1, 1, 2, 2, 2));}
        }
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

    private boolean oneTwo(ArrayList<Integer> list){
        int count = 0;
        for (Integer integer : list) {
            if (integer == 2) {
                count++;
            }
        }
        return count == 1;
    }

    private void tryOneBit(int listPos, ArrayList<Integer> input, ArrayList<Integer> swapper, ArrayList<Integer> output){
        int pos = 0;
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for(int i=0; i<input.size(); i++){
            if(swapper.get(i) == 2){pos = i;}
        }

        for (Integer integer : swapper) {
            if (integer == 1) {
                temp1.add(1);
                temp2.add(1);
            } else if (integer == 2) {
                temp1.add(2);
                temp2.add(2);
            } else {
                temp1.add(0);
                temp2.add(0);
            }
        }

        temp1.set(pos, 0);
        temp2.set(pos, 1);

        ArrayList<Integer> swapped1 = swap(input, temp1);
        ArrayList<Integer> swapped2 = swap(input, temp2);

        int count = 0;
        int hold = 0;
        if(swapped1.equals(output)){
            count++;
            hold++;
        }
        if(swapped2.equals(output)){
            count++;
        }

        if(count == 1){
            if(hold == 1){
                controlBits.set(listPos, temp1);
            }
            else{
                controlBits.set(listPos, temp2);
            }
        }
    }

    private ArrayList<Integer> swap(ArrayList<Integer> one, ArrayList<Integer> two){
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(2,2,2,2,2));

        for(int i=0; i<temp.size(); i++){
            temp.set(i, one.get(i));
        }
        int n = 4;

        for(int i=0; i<two.size(); i++){
            int first = n-i;
            int sec = n-i+1 > 4 ? 0 : n-i+1;
            int temp1 = temp.get(first);
            int temp2 = temp.get(sec);
            if(two.get(i) ==0){
                temp.set(first, temp2);
                temp.set(sec, temp1);
            }
        }
        return temp;
    }
}
