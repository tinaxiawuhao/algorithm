package search;

/**
 * @author wuhao
 * @desc 二分查找
 * @date 2020-12-17 10:08:18
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={0, 12, 28, 47, 51, 63, 67, 98, 101, 109, 117, 121, 133, 139, 141, 156, 157, 157, 181, 189, 194};
        System.out.println(binarySearch(arr,117));
        System.out.println(search(arr,117));
    }

    public static Integer binarySearch(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        while (low<high){
            int middle=(low+(high-low)>>1);
            if(arr[middle]==key){
                return middle;
            }
            if(key>arr[middle]){
                low=middle+1;
            }
            if(key<arr[middle]){
                high=middle-1;
            }
        }
        return -1;
    }

    private static int search(int[] array, int key) {
        int left=0;
        int right=array.length-1;
        while (left <= right) {
            if (array[right] == array[left]) {
                if (array[right] == key)
                    return right;
                else return -1;
            }
            int middle = left + ((key - array[left]) / (array[right] - array[left])) * (right - left);
            if (array[middle] == key) {
                return middle;
            }
            if (key < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
