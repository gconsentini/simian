package com.gconsentini.simian.helper;

import java.util.HashSet;

public class DnaHelper {
    private static final HashSet<Character> dnaBase = new HashSet<>();
    static {
        dnaBase.add('a');
        dnaBase.add('t');
        dnaBase.add('c');
        dnaBase.add('g');
        dnaBase.add('A');
        dnaBase.add('T');
        dnaBase.add('C');
        dnaBase.add('G');
    }

    public static boolean isValidDna(String[] dna){
        boolean isValid = dna.length > 0;
        for (int i = 0; isValid && i < dna.length; i++){
            if(dna.length != dna[i].length()) isValid = false;
            for(int j = 0; isValid && j < dna[i].length(); j++){
                if (!dnaBase.contains(dna[i].charAt(j))) isValid = false;
            }
        }
        return isValid;
    }

    public static boolean isSimian(String[] dna){
        int[][] directions = {{1, 0}, {1, -1}, {1, 1}, {0, 1}};
        for (int[] dir : directions) {
            for (int i = 0; i < dna.length; i++) {
                for (int j = 0; j < dna[i].length(); j++) {
                    char gene = dna[i].charAt(j);
                    if (i + 3 * dir[0] >= 0
                            && i + 3 * dir[0] < dna.length
                            && j + 3 * dir[1] >= 0
                            && j + 3 * dir[1] < dna[i].length()
                            && gene == dna[i + dir[0]].charAt(j + dir[1])
                            && gene == dna[i + 2 * dir[0]].charAt(j + 2 * dir[1])
                            && gene == dna[i + 3 * dir[0]].charAt(j + 3 * dir[1])
                    ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
