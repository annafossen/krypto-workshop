import java.util.ArrayList;

public class Translator {

    /*
     *Translating ciphertext to bits from the CCITT2 table
     */
    public static ArrayList<ArrayList<Integer>> ctToBits(ArrayList<Integer> ct){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0; i<ct.size(); i++){
            if(ct.get(i)==1){result.add(CCITT2Numbers.getN1());}
            else if(ct.get(i)==2){result.add(CCITT2Numbers.getN2());}
            else if(ct.get(i)==3){result.add(CCITT2Numbers.getN3());}
            else if(ct.get(i)==4){result.add(CCITT2Numbers.getN4());}
            else if(ct.get(i)==5){result.add(CCITT2Numbers.getN5());}
            else if(ct.get(i)==6){result.add(CCITT2Numbers.getN6());}
            else if(ct.get(i)==7){result.add(CCITT2Numbers.getN7());}
            else if(ct.get(i)==8){result.add(CCITT2Numbers.getN8());}
            else if(ct.get(i)==9){result.add(CCITT2Numbers.getN9());}
            else if(ct.get(i)==10){result.add(CCITT2Numbers.getN10());}
            else if(ct.get(i)==11){result.add(CCITT2Numbers.getN11());}
            else if(ct.get(i)==12){result.add(CCITT2Numbers.getN12());}
            else if(ct.get(i)==13){result.add(CCITT2Numbers.getN13());}
            else if(ct.get(i)==14){result.add(CCITT2Numbers.getN14());}
            else if(ct.get(i)==15){result.add(CCITT2Numbers.getN15());}
            else if(ct.get(i)==16){result.add(CCITT2Numbers.getN16());}
            else if(ct.get(i)==17){result.add(CCITT2Numbers.getN17());}
            else if(ct.get(i)==18){result.add(CCITT2Numbers.getN18());}
            else if(ct.get(i)==19){result.add(CCITT2Numbers.getN19());}
            else if(ct.get(i)==20){result.add(CCITT2Numbers.getN20());}
            else if(ct.get(i)==21){result.add(CCITT2Numbers.getN21());}
            else if(ct.get(i)==22){result.add(CCITT2Numbers.getN22());}
            else if(ct.get(i)==23){result.add(CCITT2Numbers.getN23());}
            else if(ct.get(i)==24){result.add(CCITT2Numbers.getN24());}
            else if(ct.get(i)==25){result.add(CCITT2Numbers.getN25());}
            else if(ct.get(i)==26){result.add(CCITT2Numbers.getN26());}
            else if(ct.get(i)==27){result.add(CCITT2Numbers.getN27());}
            else if(ct.get(i)==28){result.add(CCITT2Numbers.getN28());}
            else if(ct.get(i)==29){result.add(CCITT2Numbers.getN29());}
            else if(ct.get(i)==30){result.add(CCITT2Numbers.getN30());}
            else if(ct.get(i)==31){result.add(CCITT2Numbers.getN31());}
            else{result.add(CCITT2Numbers.getN32());}
        }
        return result;
    }

    /*
     *Translating bits to ciphertext from the CCITT2 table
     */
    public static Integer bitsToCt(ArrayList<Integer> list){
        if(list.equals(CCITT2Numbers.getN1())){return 1;}
        else if(list.equals(CCITT2Numbers.getN2())){return 2;}
        else if(list.equals(CCITT2Numbers.getN3())){return 3;}
        else if(list.equals(CCITT2Numbers.getN4())){return 4;}
        else if(list.equals(CCITT2Numbers.getN5())){return 5;}
        else if(list.equals(CCITT2Numbers.getN6())){return 6;}
        else if(list.equals(CCITT2Numbers.getN7())){return 7;}
        else if(list.equals(CCITT2Numbers.getN8())){return 8;}
        else if(list.equals(CCITT2Numbers.getN9())){return 9;}
        else if(list.equals(CCITT2Numbers.getN10())){return 10;}
        else if(list.equals(CCITT2Numbers.getN11())){return 11;}
        else if(list.equals(CCITT2Numbers.getN12())){return 12;}
        else if(list.equals(CCITT2Numbers.getN13())){return 13;}
        else if(list.equals(CCITT2Numbers.getN14())){return 14;}
        else if(list.equals(CCITT2Numbers.getN15())){return 15;}
        else if(list.equals(CCITT2Numbers.getN16())){return 16;}
        else if(list.equals(CCITT2Numbers.getN17())){return 17;}
        else if(list.equals(CCITT2Numbers.getN18())){return 18;}
        else if(list.equals(CCITT2Numbers.getN19())){return 19;}
        else if(list.equals(CCITT2Numbers.getN20())){return 20;}
        else if(list.equals(CCITT2Numbers.getN21())){return 21;}
        else if(list.equals(CCITT2Numbers.getN22())){return 22;}
        else if(list.equals(CCITT2Numbers.getN23())){return 23;}
        else if(list.equals(CCITT2Numbers.getN24())){return 24;}
        else if(list.equals(CCITT2Numbers.getN25())){return 25;}
        else if(list.equals(CCITT2Numbers.getN26())){return 26;}
        else if(list.equals(CCITT2Numbers.getN27())){return 27;}
        else if(list.equals(CCITT2Numbers.getN28())){return 28;}
        else if(list.equals(CCITT2Numbers.getN29())){return 29;}
        else if(list.equals(CCITT2Numbers.getN30())){return 30;}
        else if(list.equals(CCITT2Numbers.getN31())){return 31;}
        else{return 32;}
    }
}
