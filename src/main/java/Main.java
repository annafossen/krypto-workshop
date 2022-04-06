import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static final PlugBits plugBits = new PlugBits();
    private static final ControlBits controlBits = new ControlBits();
    private static final First5Rotors first5Rotors = new First5Rotors();
    private static final Last5Rotors last5Rotors = new Last5Rotors();
    private static final Rotors rotors = new Rotors();

    // Ciphertext.
    public static ArrayList<Integer> ct = new ArrayList<>(Arrays.asList(24, 17, 9, 24, 32, 2, 8, 6, 3, 28, 32, 4, 27, 27, 20, 26, 18, 16, 24, 24, 7,
            11, 12, 22, 11, 4, 8, 12, 21, 17, 6, 27, 9, 28, 29, 21, 5, 4, 8, 18, 6, 3, 30,
            29, 6, 30, 26, 6, 22, 14, 2, 15, 4, 14, 14, 27, 12, 27, 27, 8, 7, 10, 27, 3, 18, 19, 1, 12, 31, 9, 18, 19, 29, 11, 7, 15, 11, 18, 28, 29, 27, 9, 32, 20, 9, 19, 17, 25, 25, 25, 7, 4, 24, 31, 20, 31, 27, 6, 18, 1, 28, 11, 20, 14, 13, 16, 18, 14, 28, 19, 27, 7, 9, 19, 26, 21, 18, 20, 13, 14, 24, 32, 3, 13, 3, 21, 30, 26, 25, 6, 27, 23, 14, 12, 25, 3, 19, 24, 8, 9, 6, 31, 6, 4, 32, 11, 27, 11, 18, 18, 21, 23, 4, 15, 26, 16, 4, 14, 16, 10, 8, 5, 28, 28, 27, 16, 18, 23, 1, 18, 9,
            20, 13, 25, 12, 21, 19, 16, 4, 4, 29, 7, 31, 17, 23, 30, 32, 18, 8, 9, 2, 3, 28, 4, 20, 32, 2, 29, 18, 32, 10, 21, 12, 3, 16, 32, 1, 4, 18, 32, 29, 18, 23, 11, 23, 12, 4, 24, 25, 27, 25, 25, 21, 13, 9, 19, 22, 14, 29, 30, 29, 19, 25, 15, 1, 7, 18, 27, 1, 27, 7, 21, 21, 5, 5, 24, 21, 4, 5, 11, 5, 32, 6, 31, 1, 21, 6, 28, 25, 17, 9, 27, 4, 1, 1, 27, 30, 5, 15, 4, 4, 24, 13, 11, 12, 19, 6, 20, 19, 27, 14, 27, 15, 29, 14, 30, 15, 15, 30, 13, 12, 8, 12, 3, 8, 2, 16, 18, 6, 28, 20, 25, 8, 9, 21, 3, 4, 4, 16, 15, 27, 25, 20, 21, 9, 9, 8, 26, 6, 18, 20, 23, 16,
            10, 24, 24, 32, 30, 11, 5, 20, 31, 29, 21, 12, 23, 13, 12, 32, 19, 13, 21, 7, 29, 4, 5, 11, 18, 10, 23, 28, 24, 15, 31, 23, 16, 3, 8, 20, 30, 9, 23, 9, 21,
            23, 4, 23, 9, 24, 16, 9, 5, 2, 10, 32, 13, 24, 4, 12, 25, 9, 4, 6, 13, 32, 5,
            14, 12, 18, 18, 26, 32, 22, 32, 13, 11, 23, 2, 30, 10, 30, 31, 29, 5, 10, 14, 18, 14, 17, 31, 13, 21, 14, 32, 4, 21, 25, 28, 14, 11, 4, 27, 14, 18, 31, 4, 16, 24, 25, 17, 4, 2, 1, 30, 11, 2, 3, 15, 25, 1, 1, 16, 20, 1, 16, 9, 16, 17, 3,
            27, 9, 26, 3, 17, 14, 10, 8, 7, 13, 25, 24, 15, 11, 1, 20, 30, 21, 10, 14, 10, 22, 1, 32, 7, 9, 29, 15, 17, 1, 23, 30, 28, 32, 16, 29, 7, 26, 21, 23, 15, 5,
            27, 13, 22, 18, 9, 12, 2, 7, 26, 21, 26, 1, 2, 10, 6, 22, 11, 26, 3, 29, 29, 25, 3, 13, 16, 13, 10, 3, 27, 1, 26, 16, 20, 17, 31, 19, 30, 14, 23, 7, 24, 30, 12, 30, 11, 14, 13, 8, 26, 4, 18, 29, 14, 16, 3, 8, 31, 22, 23, 29, 22, 6, 30, 29, 10, 23, 31, 15, 4, 18, 1, 3, 9, 29, 2, 23, 18, 27, 9, 3, 20, 19, 6, 11, 13, 2,
            28, 4, 25, 24, 31, 10, 17, 22, 22, 21, 15, 22, 4, 27, 3, 22, 14, 21, 28, 24, 21, 15, 32, 6, 14, 22, 14, 21, 20, 4, 5, 29, 25, 6, 9, 26, 29, 23, 10, 16, 16, 30, 21, 20, 32, 26, 15, 22, 11, 3, 22, 28, 17, 7, 30, 16, 2, 4, 14, 14, 12, 5, 2,
            15, 22, 28, 21, 21, 11, 32, 24, 22, 6, 15, 18, 15, 2, 25, 16, 5, 7, 18, 4, 7,
            28, 13, 25, 15, 25, 11, 16, 1, 7, 26, 9, 12, 18, 3, 7, 21, 28, 5, 4, 31, 30, 21, 31, 24, 29, 12, 27, 20, 25, 19, 9, 3, 29, 20, 25, 29, 25, 19, 16, 11, 24, 24, 13, 15, 23, 30, 25, 20, 16, 30, 5, 6, 26, 15, 29, 15, 5, 19, 27, 6, 28, 3, 31, 32, 27, 1, 12, 10, 11, 3, 16, 21, 2, 12, 25, 29, 11, 14, 16, 2, 14, 17, 4, 30,
            1, 13, 10, 14, 1, 31, 29, 22, 10, 19, 4, 30, 2, 16, 3, 23, 2, 24, 19, 29, 10,
            14, 4, 6, 18, 26, 22, 13, 15, 4, 13, 15, 7, 5, 15, 28, 17, 13, 12, 26, 24, 17,
            5, 10, 19, 18, 13, 6, 16, 5, 2, 17, 24, 15, 26, 22, 12, 4, 16, 19, 20, 11, 5,
            20, 9, 28, 19, 28, 21, 21, 23, 28, 25, 30, 1, 26, 25, 9, 27, 7, 28, 22, 24, 1, 1, 6, 30, 18, 4, 23, 6, 1, 10, 1, 17, 11, 15, 26, 19, 18, 12, 13, 8, 16, 25, 4, 24, 24, 27, 26, 24, 19, 2, 14, 18, 28, 10, 29, 3, 20, 7, 25, 19, 11, 27, 19, 15, 11, 14, 31, 24, 15, 7, 16, 10, 24, 27, 13, 25, 16, 30, 31, 31, 7, 15, 28, 29, 14, 24, 25, 6, 26, 26, 29, 14, 13, 1, 22, 8, 22, 4, 25, 22, 2, 10, 9, 10, 22, 15, 16, 5, 5, 19, 22, 5, 24, 7, 3, 21, 23, 20, 21, 13, 31, 25, 8, 20, 3, 17, 18, 17, 6, 15, 30, 11, 2, 28, 30, 15, 12, 8, 16, 3, 29, 28, 15, 13, 18, 12, 22, 17, 6, 27, 22, 1, 27, 6, 17, 22, 2, 18, 20, 6, 28, 5, 9, 1, 11, 2, 7, 9, 25, 3, 23, 18, 30, 26, 25, 2, 12, 32, 24, 5, 3, 8, 1, 16, 8, 20, 32, 30, 13, 4, 23, 31, 21, 13, 7, 16, 17, 14, 21, 8, 5, 20, 25, 12, 24, 6, 3, 21, 2, 31, 26, 30, 5, 26, 30, 6, 32, 2, 32, 27, 26, 13, 25, 16, 13, 20, 12, 7, 12, 21, 4, 11, 19, 26, 6, 21,
            9, 24, 12, 24, 14, 10, 11, 16, 31, 7, 10, 15, 14, 31, 1, 5, 22, 4, 25, 14, 27, 12, 26, 11, 29, 7, 25, 15, 30, 12, 14, 9, 22, 30, 32, 24, 5, 27, 11, 28, 6, 11, 27, 22, 21, 28, 5, 15, 13, 26, 22, 10, 31, 3, 30, 3, 30, 21, 30, 24, 19, 3, 12, 21, 10, 17, 30, 9, 21, 20, 23, 18, 28, 24, 2, 18, 2, 10, 14, 18, 2, 28, 19, 20, 12, 5, 22, 5, 28, 25, 26, 27, 8, 30, 2, 12, 18, 15, 23, 20, 1, 32, 27, 16, 27, 32, 23, 19, 28, 6, 19, 22, 22, 3, 17, 1, 13, 31, 20, 7, 24, 23, 2, 21, 7, 28, 17, 5, 2, 18, 25, 11, 8, 16, 13, 12, 19, 24, 26, 24, 18, 21, 29, 22, 22, 14, 1, 3, 18, 26, 12, 3, 32, 25, 28, 12, 1, 25, 26, 17, 4, 28, 2, 20, 9, 18, 16, 11, 4, 17, 7, 4, 21, 28, 6, 12, 6, 16, 15, 12, 25, 28, 22, 4, 4, 32, 15, 9, 3, 19, 26, 1, 2, 22, 23, 26, 11, 2, 11, 11, 27, 20, 7, 5, 9, 11, 22, 2, 20, 3, 25, 2, 2,
            28, 6, 10, 3, 12, 19, 11, 2, 21, 30, 18, 4, 28, 24, 3, 23, 2));

    // The list that holds the result of the XOR operation between 5-bit groups from plugBits and the corresponding letter from the alphabet.
    private static final ArrayList<ArrayList<Integer>> xored = new ArrayList<>();

    // The list with the last 26 characters encrypted.
    private static final ArrayList<Integer> newCt = new ArrayList<>();

    public static void main(String[] args) {
        // The list that holds the bit representation of the ciphertext.
        ArrayList<ArrayList<Integer>> ctBits = Translator.ctToBits(ct);
        plugBits.fillBitsFromAllZeroOrAllOne(ct);
        plugBits.loopToFindRotors(rotors, first5Rotors);
        plugBits.regeneratePlugBits(first5Rotors, ctBits);
        fillXored();
        controlBits.fillControlBitsFromWeight(xored, ctBits);
        controlBits.loopToFindRotors(rotors, last5Rotors);
        controlBits.regenerateControlBits(last5Rotors, xored, ctBits);
        encrypt();
        printPretty();
    }

    //TODO: Oppgave 4
    private static void fillXored(){
        for(int i=0; i<plugBits.size(); i++){
            //TODO: Bruk metoden "xor" og legg til resultatet i listen "xored" på linjen under. Her må du bruke index i for å finne
            // riktig 5-bit gruppe i plugBits og fra alfabetet. Husk å bruke modulo operator med index i når du henter fra alfabetet!

        }
    }

    private static void encrypt(){
        for(int i=1274; i<1300; i++){
            ArrayList<Integer> plugBits = new ArrayList<>(
                    Arrays.asList(first5Rotors.getRotorFromIndex(0).getWheel().get(i%first5Rotors.getRotorFromIndex(0).getWheel().size()),
                            first5Rotors.getRotorFromIndex(1).getWheel().get(i%first5Rotors.getRotorFromIndex(1).getWheel().size()),
                            first5Rotors.getRotorFromIndex(2).getWheel().get(i%first5Rotors.getRotorFromIndex(2).getWheel().size()),
                            first5Rotors.getRotorFromIndex(3).getWheel().get(i%first5Rotors.getRotorFromIndex(3).getWheel().size()),
                            first5Rotors.getRotorFromIndex(4).getWheel().get(i%first5Rotors.getRotorFromIndex(4).getWheel().size())));

            ArrayList<Integer> controlBits = new ArrayList<>(
                    Arrays.asList(last5Rotors.getRotorFromIndex(0).getWheel().get(i%last5Rotors.getRotorFromIndex(0).getWheel().size()),
                            last5Rotors.getRotorFromIndex(1).getWheel().get(i%last5Rotors.getRotorFromIndex(1).getWheel().size()),
                            last5Rotors.getRotorFromIndex(2).getWheel().get(i%last5Rotors.getRotorFromIndex(2).getWheel().size()),
                            last5Rotors.getRotorFromIndex(3).getWheel().get(i%last5Rotors.getRotorFromIndex(3).getWheel().size()),
                            last5Rotors.getRotorFromIndex(4).getWheel().get(i%last5Rotors.getRotorFromIndex(4).getWheel().size())));

            ArrayList<Integer> xored = xor(plugBits, CCITT2Alphabet.getAlphabet().get(i%26));
            ArrayList<Integer> result = swap(xored, controlBits);
            newCt.add(Translator.bitsToCt(result));
        }
    }

    private static ArrayList<Integer> xor(ArrayList<Integer> one, ArrayList<Integer> two){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<5; i++){
            int num1 = one.get(i);
            int num2 = two.get(i);
            result.add(num1^num2);
        }
        return result;
    }

    private static ArrayList<Integer> swap(ArrayList<Integer> one, ArrayList<Integer> two){
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

    //#############PRINTING PRETTY#############

    private static void printPretty(){
        System.out.print("New ciphertext: ");
        for (Integer integer : newCt) {
            System.out.print(integer + " ");
        }

        System.out.println();

        System.out.println("Initial state: "
                + first5Rotors.getRotorFromIndex(0).getWheel().get(0)
                + first5Rotors.getRotorFromIndex(1).getWheel().get(0)
                + first5Rotors.getRotorFromIndex(2).getWheel().get(0)
                + first5Rotors.getRotorFromIndex(3).getWheel().get(0)
                + first5Rotors.getRotorFromIndex(4).getWheel().get(0)
                + last5Rotors.getRotorFromIndex(0).getWheel().get(0)
                + last5Rotors.getRotorFromIndex(1).getWheel().get(0)
                + last5Rotors.getRotorFromIndex(2).getWheel().get(0)
                + last5Rotors.getRotorFromIndex(3).getWheel().get(0)
                + last5Rotors.getRotorFromIndex(4).getWheel().get(0));
        for (Rotor rotor : rotors.getRotors()) {
            if (first5Rotors.getRotors().contains(rotor)) {
                int index = first5Rotors.getRotors().indexOf(rotor) + 1;
                System.out.print("Rotor " + rotor.getWheel().size() + " (0" + index + "): ");
            } else {
                int index = last5Rotors.getRotors().indexOf(rotor) + 6;
                if (index != 10) {
                    System.out.print("Rotor " + rotor.getWheel().size() + " (0" + index + "): ");
                } else {
                    System.out.print("Rotor " + rotor.getWheel().size() + " (" + index + "): ");
                }
            }
            for (int j = 0; j < rotor.getWheel().size(); j++) {
                System.out.print(rotor.getWheel().get(j));
            }
            System.out.println();
        }
    }

    private static void printRotor(ArrayList<Integer> rotor){
        System.out.print("Rotor " + rotor.size() + ": ");
        for (Integer integer : rotor) {
            System.out.print(integer);
        }
        System.out.println();
    }

    private static void first5RotorsPrintPretty(){
        for (Rotor rotor : rotors.getRotors()) {
            if (first5Rotors.getRotors().contains(rotor)) {
                int index = first5Rotors.getRotors().indexOf(rotor) + 1;
                System.out.print("Rotor " + rotor.getWheel().size() + " (0" + index + "): ");

                for (int j = 0; j < rotor.getWheel().size(); j++) {
                    System.out.print(rotor.getWheel().get(j));
                }
                System.out.println();
            }
        }
    }

    private static void last5RotorsPrintPretty(){
        for (Rotor rotor : rotors.getRotors()) {
            if (last5Rotors.getRotors().contains(rotor)) {
                int index = last5Rotors.getRotors().indexOf(rotor) + 6;
                if (index != 10) {
                    System.out.print("Rotor " + rotor.getWheel().size() + " (0" + index + "): ");
                } else {
                    System.out.print("Rotor " + rotor.getWheel().size() + " (" + index + "): ");
                }

                for (int j = 0; j < rotor.getWheel().size(); j++) {
                    System.out.print(rotor.getWheel().get(j));
                }
                System.out.println();
            }
        }
    }

    //#########################################


}
