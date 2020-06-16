package leetcode;

import java.util.HashMap;

/**
 * 拼写单词
 */
public class FindWordsThatCanBeFormedByCharacters_1160 {
    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";


//        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
//        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        countCharacters(words, chars);
    }

    /**
     *暴力法
     * 1.chars 中的每个字母 每个words只能只能使用一次 （需要统计 chars中每个字母出现的次数）
     * 这里用 HashMap key 是词，value 是次数
     * 2.为了符合条件，也要统计 words 中每个 word 中的每个字母的出现次数，如果出现次数小于等于 chars 字母的次数 则成立
     */
    public static int countCharacters(String[] words, String chars) {
        if (chars == null || words.length < 1) {
            return 0;
        }
        int target = 0;
        HashMap<Character, Integer> charsMap = new HashMap<>();
        HashMap<Character, Integer> wordsMap;
        //统计了 chars 每个字母出现的次数
        for (char c : chars.toCharArray()) {
            charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
        }
        //统计了 word 每个字母出现的次数
        boolean isAdd = true;
        for (String word : words) {
            wordsMap = new HashMap<>();
            for (char w : word.toCharArray()) {
                wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
                if (charsMap.get(w)==null){
                    isAdd=false;
                    break;
                }
                if (wordsMap.get(w) > charsMap.get(w)) {
                    isAdd = false;
                    break;
                } else {
                    isAdd = true;
                }
            }
            if (isAdd) {
                target += word.length();
                System.out.println(target);
            }
        }
        return target;
    }
}
