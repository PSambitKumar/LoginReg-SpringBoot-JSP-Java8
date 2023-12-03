package com.sambit.CompetitvePractice.Basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        Set<String> set = permutationOfString("ABC");
        System.out.println("Permutations of String ABC are:");
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            String string = iterator.next();
            System.out.println(string);
        }
    }

    public static Set<String> permutationOfString(String str) {
        Set<String> permutationSet = new HashSet<>();

        if (str.length() == 0) {
            permutationSet.add("");
            return permutationSet;
        }

        char c = str.charAt(0);
        String rem = str.substring(1);

        Set<String> permutatedSetForRemainingString = permutationOfString(rem);
        for (String permutedString : permutatedSetForRemainingString) {
            for (int j = 0; j <= permutedString.length(); j++) {
                String permutation = insertFirstCharAtDiffPlaces(permutedString, c, j);
                permutationSet.add(permutation);
            }
        }
        return permutationSet;
    }

    public static String insertFirstCharAtDiffPlaces(String perm, char firstChar, int index) {
        return perm.substring(0, index) + firstChar + perm.substring(index);
    }
}
