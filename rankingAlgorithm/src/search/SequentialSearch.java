package search;

/**
 * @author wuhao
 * @desc 顺序查找
 * @date 2020-12-17 09:54:19
 */
public class SequentialSearch {
    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};

        System.out.println(search(arr,117));
    }

    public static Integer search(int[] arr,int key){
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}
