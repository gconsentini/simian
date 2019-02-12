package com.gconsentini.simian.helper;

public class DnaHelper {

    public static boolean isSimian(String[] dnaSequence){
        int[][] directions = {{1, 0}, {1, -1}, {1, 1}, {0, 1}};
        for (int[] dir : directions) {
            for (int i = 0; i < dnaSequence.length; i++) {
                for (int j = 0; j < dnaSequence[i].length(); j++) {
                    char gene = dnaSequence[i].charAt(j);
                    if (i + 3 * dir[0] >= 0
                            && i + 3 * dir[0] < dnaSequence.length
                            && j + 3 * dir[1] >= 0
                            && j + 3 * dir[1] < dnaSequence[i].length()
                            && gene == dnaSequence[i + dir[0]].charAt(j + dir[1])
                            && gene == dnaSequence[i + 2 * dir[0]].charAt(j + 2 * dir[1])
                            && gene == dnaSequence[i + 3 * dir[0]].charAt(j + 3 * dir[1])
                    ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
