package leetcode;

/**
 * @author wuhao
 * @desc 906. 超级回文数
 * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
 * <p>
 * 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：L = "4", R = "1000"
 * 输出：4
 * 解释：
 * 4，9，121，以及 484 是超级回文数。
 * 注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= len(L) <= 18
 * 1 <= len(R) <= 18
 * L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
 * int(L) <= int(R)
 * @date 2021-05-25 14:13:41
 */
class Solution24 {
    public static void main(String[] args) {
        System.out.println(superpalindromesInRange("1", "10000000000000"));
    }

    public static int superpalindromesInRange(String left, String right) {
//        long L = Long.valueOf(left);
//        long R = Long.valueOf(right);
//        int MAGIC = 100000;
//        int ans = 0;
//
//        // count odd length;
//        for (int k = 1; k < MAGIC; ++k) {
//            StringBuilder sb = new StringBuilder(Integer.toString(k));
//            for (int i = sb.length() - 2; i >= 0; --i)
//                sb.append(sb.charAt(i));
//            long v = Long.valueOf(sb.toString());
//            v *= v;
//            if (v > R) break;
//            if (v >= L && isPalindrome(v)) ans++;
//        }
//
//        // count even length;
//        for (int k = 1; k < MAGIC; ++k) {
//            StringBuilder sb = new StringBuilder(Integer.toString(k));
//            for (int i = sb.length() - 1; i >= 0; --i)
//                sb.append(sb.charAt(i));
//            long v = Long.valueOf(sb.toString());
//            v *= v;
//            if (v > R) break;
//            if (v >= L && isPalindrome(v)) ans++;
//        }
//
//        return ans;
        long table[]=new long[]{1L,4L,9L,121L,484L,10201L,12321L,14641L,40804L,44944L,1002001L,1234321L,4008004L,100020001L,102030201L,104060401L,121242121L,123454321L,125686521L,400080004L,404090404L,10000200001L,10221412201L,12102420121L,12345654321L,40000800004L,1000002000001L,1002003002001L,1004006004001L,1020304030201L,1022325232201L,1024348434201L,1210024200121L,1212225222121L,1214428244121L,1232346432321L,1234567654321L,4000008000004L,4004009004004L,100000020000001L,100220141022001L,102012040210201L,102234363432201L,121000242000121L,121242363242121L,123212464212321L,123456787654321L,400000080000004L,10000000200000001L,10002000300020001L,10004000600040001L,10020210401202001L,10022212521222001L,10024214841242001L,10201020402010201L,10203040504030201L,10205060806050201L,10221432623412201L,10223454745432201L,12100002420000121L,12102202520220121L,12104402820440121L,12122232623222121L,12124434743442121L,12321024642012321L,12323244744232321L,12343456865434321L,12345678987654321L,40000000800000004L,40004000900040004L,1000000002000000001L,1000220014100220001L,1002003004003002001L,1002223236323222001L,1020100204020010201L,1020322416142230201L,1022123226223212201L,1022345658565432201L,1210000024200000121L,1210242036302420121L,1212203226223022121L,1212445458545442121L,1232100246420012321L,1232344458544432321L,1234323468643234321L,4000000008000000004L};
        long L = Long.valueOf(left);
        long R = Long.valueOf(right);
        int number=0;
        for (int i = 0; i < table.length; i++) {
            if(table[i]>=L&&table[i]<=R){
                number++;
            }
        }
        return number;
    }

//    public static boolean isPalindrome(long x) {
//        return x == reverse(x);
//    }
//
//    public static long reverse(long x) {
//        long ans = 0;
//        while (x > 0) {
//            ans = 10 * ans + x % 10;
//            x /= 10;
//        }
//
//        return ans;
//    }
}