import java.util.ArrayList;
import java.util.Arrays;

public class CCITT2Alphabet {

    // The letters in the alphabet represented as 5-bit groups. These are taken from the CCITT2 table.
    private static final ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,0,0,0));
    private static final ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1,0,0,1,1));
    private static final ArrayList<Integer> c = new ArrayList<>(Arrays.asList(0,1,1,1,0));
    private static final ArrayList<Integer> d = new ArrayList<>(Arrays.asList(1,0,0,1,0));
    private static final ArrayList<Integer> e = new ArrayList<>(Arrays.asList(1,0,0,0,0));
    private static final ArrayList<Integer> f = new ArrayList<>(Arrays.asList(1,0,1,1,0));
    private static final ArrayList<Integer> g = new ArrayList<>(Arrays.asList(0,1,0,1,1));
    private static final ArrayList<Integer> h = new ArrayList<>(Arrays.asList(0,0,1,0,1));
    private static final ArrayList<Integer> i = new ArrayList<>(Arrays.asList(0,1,1,0,0));
    private static final ArrayList<Integer> j = new ArrayList<>(Arrays.asList(1,1,0,1,0));
    private static final ArrayList<Integer> k = new ArrayList<>(Arrays.asList(1,1,1,1,0));
    private static final ArrayList<Integer> l = new ArrayList<>(Arrays.asList(0,1,0,0,1));
    private static final ArrayList<Integer> m = new ArrayList<>(Arrays.asList(0,0,1,1,1));
    private static final ArrayList<Integer> n = new ArrayList<>(Arrays.asList(0,0,1,1,0));
    private static final ArrayList<Integer> o = new ArrayList<>(Arrays.asList(0,0,0,1,1));
    private static final ArrayList<Integer> p = new ArrayList<>(Arrays.asList(0,1,1,0,1));
    private static final ArrayList<Integer> q = new ArrayList<>(Arrays.asList(1,1,1,0,1));
    private static final ArrayList<Integer> r = new ArrayList<>(Arrays.asList(0,1,0,1,0));
    private static final ArrayList<Integer> s = new ArrayList<>(Arrays.asList(1,0,1,0,0));
    private static final ArrayList<Integer> t = new ArrayList<>(Arrays.asList(0,0,0,0,1));
    private static final ArrayList<Integer> u = new ArrayList<>(Arrays.asList(1,1,1,0,0));
    private static final ArrayList<Integer> v = new ArrayList<>(Arrays.asList(0,1,1,1,1));
    private static final ArrayList<Integer> w = new ArrayList<>(Arrays.asList(1,1,0,0,1));
    private static final ArrayList<Integer> x = new ArrayList<>(Arrays.asList(1,0,1,1,1));
    private static final ArrayList<Integer> y = new ArrayList<>(Arrays.asList(1,0,1,0,1));
    private static final ArrayList<Integer> z = new ArrayList<>(Arrays.asList(1,0,0,0,1));

    public static ArrayList<ArrayList<Integer>> getAlphabet () {
        return new ArrayList<>(Arrays.asList(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z));
    }
}
