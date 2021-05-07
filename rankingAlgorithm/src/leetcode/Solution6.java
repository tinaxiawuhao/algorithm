package leetcode;

/**
 * @author wuhao
 * @desc ...
 * @date 2021-05-06 10:39:56
 */
public class Solution6 {
    public static void main(String[] args) {
        System.out.println(reformatNumber("123 4-567"));

    }
    public static String reformatNumber(String number) {
        number = number.replace(" ","");
        number = number.replace("-","");
        number = number.replaceAll("(?<=\\G\\d{3})(?!$)", "-");
        number = number.replaceAll("\\b(\\d{2})(\\d+)-(\\d)$", "$1-$2$3");
        return number;
    }
}
