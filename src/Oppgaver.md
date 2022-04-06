#Oppgaver

Knekk en rotormaskin! For å gjøre denne oppgaven litt enklere så er cipherteksten i denne oppgaven bare alfabetetet 
repetert 28 ganger sånn at man kan finne rotorene sine perioder(lengde), i hvilken rekkefølge de er satt opp og 
den initielle instillingen på rotorene(utgangspunkt før kryptering). Når det er funnet skal vi verifisere med å kryptere 
en runde til med alfabetet :) 

###Oppgave 1: 
Se i PlugBits.java og implementer det som mangler i metoden "fillBitsFromAllZeroOrAllOne".

###Oppgave 2:
Se i PlugBits.java og implementer det som mangler i metoden "loopToFindRotor".

###Oppgave 3:
Se i PlugBits.java og implementer det som mangler i metoden "regeneratePlugBits".

###Oppgave 4:
Se i Main.java og implementer det som mangler i metoden "fillXored".

###Oppgave 5:   
Se i ControlBits.java og implementer det som mangler i metoden "fillControlBitsFromWeight".
  

#HINT: 

###Oppgave 1:

```
if(ct.get(i) == 32){
    ArrayList<Integer> result = xor(CCITT2Numbers.getN32(), CCITT2Alphabet.getAlphabet().get(i%26));
    plugBits.set(i, result);
}`
```

```
if(ct.get(i) == 29){
    ArrayList<Integer> result = xor(CCITT2Numbers.geN29(), CCITT2Alphabet.getAlphabet().get(i%26));
    plugBits.set(i, result);
}
```
###Oppgave 2:

```
int nextPos = j + (period*numPeriods);
```

###Oppgave 3:

````
fillRotorsAndBits(first5Rotors.getRotors(), plugBits);
````

###Oppgave 4:

```
xored.add(xor(plugBits.get(i), CCITT2Alphabet.getAlphabet().get(i%26)));
```

###Oppgave 5:

````
controlBits.set(i, weightOne(xored.get(i), ctBits.get(i)));
````

````
controlBits.set(i, weightFour(xored.get(i), ctBits.get(i)));
````

