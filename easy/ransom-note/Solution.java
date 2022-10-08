import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        ArrayList<Character> magazineLetters = new ArrayList<>();

        for (char c : magazine.toCharArray()) {
            magazineLetters.add(c);
        }

        for (Character c : ransomNote.toCharArray()) {
            if (magazineLetters.contains(c)) {
                magazineLetters.remove(c);
            } else {
                return false;
            }
        }

        return true;
    }
}

class Solution2 {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        HashSet<Integer> usedLetters = new HashSet<>();
        boolean hasLetter;

        for (int i = 0; i < ransomNote.length(); i++) {
            hasLetter = false;
            for (int j = 0; j < magazine.length(); j++) {
                if (!usedLetters.contains(j) && ransomNote.charAt(i) == magazine.charAt(j)) {
                    usedLetters.add(j);
                    hasLetter = true;
                    break;
                }
            }
            if (!hasLetter) {
                return false;
            }
        }

        return true;
    }
}

class Solution3 {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        
        ArrayList<Character> magazineLetters = new ArrayList<>();

        for (char c : magazine.toCharArray()) {
            magazineLetters.add(c);
        }

        for (Character c : ransomNote.toCharArray()) {
            if (magazineLetters.contains(c)) {
                magazineLetters.remove(c);
            } else {
                return false;
            }
        }

        return true;
    }
}