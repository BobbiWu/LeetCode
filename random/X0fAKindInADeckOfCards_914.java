package leetcode;

import java.util.HashMap;

/**
 * 卡牌分组
 */
public class X0fAKindInADeckOfCards_914 {
    public static void main(String[] args) {
//        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
//        int[] deck = {1,1,1,2,2,2,3,3};
        int[] deck = {0,0,0,1,1,1,2,2,2};
//        int[] deck = {0, 0, 0, 0, 0, 1, 1, 2, 3, 4};
//        int[] deck = {1, 1, 2, 2, 2, 2};
//        int[] deck = {1, 1, 1, 2, 2, 2, 3, 3};
//        int[] deck = {0,0,1,1,1,1,2,2,3,4};
//        int[] deck = {0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 3, 3, 4, 5, 6};
        System.out.println(hasGroupsSizeX(deck));
    }

    /**
     * HashMap算法
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int decks : deck) {
            int value = 0;
            if (!map.containsKey(decks)) {
                map.put(decks, ++value);
            } else {
                Integer oldValue = map.get(decks);
                map.put(decks, ++oldValue);
            }
        }
        int x = 2;
        for (int value : deck) {
            if (map.get(value) > 0) {
                x = gcd(x, map.get(value));
                if (x == 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
