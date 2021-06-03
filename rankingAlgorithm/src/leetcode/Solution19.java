package leetcode;

import java.util.*;

/**
 * @author wuhao
 * @desc 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * @date 2021-05-19 14:13:41
 */
class Solution19 {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            if (map.get(words[i]) == null) {
//                map.put(words[i], 1);
//            } else {
//                map.put(words[i], map.get(words[i])+1);
//            }
//        }
//        List<String> list = new ArrayList<>(map.keySet());
//        Collections.sort(list, new Comparator<String>() {
//            public int compare(String word1, String word2) {
//                return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
//            }
//        });
//        return list.subList(0, k);
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
}