import java.util.*;
class RomanNumeralsConverter {
    public int convert(String s) {
        Map numerals = new HashMap<String, Integer>();
        numerals.put("I", 1);
        numerals.put("V", 5);
        numerals.put("X", 10);
        numerals.put("L", 50);
        numerals.put("C", 100);
        numerals.put("D", 500);
        numerals.put("M", 1000);
        Integer total = 0;
        String[] letters = s.split("");
        // for all but last letter
        for (int i = 0; i < (letters.length)-1; i++) {
            Integer currentValue = (Integer) numerals.get(letters[i]); 
            Integer nextValue = (Integer) numerals.get(letters[i+1]);
            // if the next character is bigger, subtract the current value from the total
            if ((currentValue < nextValue)) {
                total -= currentValue;
                continue;
            }
            total += currentValue;
        }
        // add on the last number since will always be addition
        total += (Integer) numerals.get(letters[letters.length-1]);
        System.out.println(total.toString());
        return total;
    }
    public static void main(String[] args){
        RomanNumeralsConverter c = new RomanNumeralsConverter();
        c.convert("XVI");
        c.convert("MMXXII");
        c.convert("MCMXCIX");
    }
}