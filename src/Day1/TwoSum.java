package Day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    int[] indexArr;
    public static void main(String[] args) {
        // assuming there is only one solution:
        // for target=9, array={2, 11, 7, -1, 5} is ok, but array={2, 11, 7, -1, 5, 10} or array={2, 11, 7, -1, 5, 10, 2} not
        int[] array={10, 11, 7, -1, 5, 2};
        int target=9;
        System.out.println("target = " + target);
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("twoSum1(array,target) = " + Arrays.toString(twoSum1(array, target)));
        System.out.println("twoSum2(array,target) = " + Arrays.toString(twoSum2(array, target)));
        System.out.println("twoSum3(array,target) = " + Arrays.toString(twoSum3(array, target)));
    }

    public static int[] twoSum1(int[] arr, int target){
        int[] indexArr=new int[2] ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
               if(arr[i]+arr[j]==target){
                   indexArr[0]=i;
                   indexArr[1]=j;
               }
            }
        }
        return indexArr;
    }// end of method1

    public static int[] twoSum2(int[] arr, int target){
        int[] indexArr=new int[2];
        int[] twoNums;
        // find one pair summing numbers to the target
        twoNums=findTwoNums(arr, target);

        // to find the indices of the values in the array:
        indexArr[0]=findIndexArray(arr, twoNums[0]);
        indexArr[1]=findIndexArray(arr, twoNums[1]);

        // to get indexArr sorted
        Arrays.sort(indexArr);
        return indexArr;
    }


    public static int[] twoSum3(int[] arr, int target){
        int[] indexArr=new int[2];
        HashMap<Integer, Integer> map= (HashMap<Integer, Integer>) arrayToMap(arr);
        int[] twoNums;
        twoNums=findTwoNums(arr, target);
        //find the index of first value
        //indexArr[0]=getKey(map, twoNums[0]);
        indexArr[0]=findIndexByMap(map,twoNums[0]);
        //find the index of the second value
        //indexArr[1]=getKey(map, twoNums[1]);
        indexArr[1]=findIndexByMap(map,twoNums[1]);
        // to get indexArr sorted
        Arrays.sort(indexArr);
        return indexArr;
    }

    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static Map<Integer, Integer> arrayToMap(int[] arr){
        Map<Integer, Integer> map=new HashMap<>();
        //array elements added to the map
        for (int i = 0; i <arr.length ; i++) {
            map.put(i, arr[i]);
        }
        //System.out.println("map = " + map);
        return map;
    }

    public static int findSecondNum(int[] arr, HashMap<Integer,Integer> map, int target) {
        int secondNum=0;
        for (int num : arr) {
            // if map contains the element with the value: target-arr[i],
            // we got the value of the element, but not the index: map has no index
            if (map.containsValue(target - num)) {
                // we found the matching value and the first index
                secondNum = target - num;
            }
        }
        return secondNum;
    }

    public static int findIndexArray(int [] arr, int num){
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if(num==arr[i]){ index=i; break;}
        }
        return index;
    }

    public static int findIndexByMap(HashMap<Integer,Integer> map, int num){

        if(map.containsValue(num)){
            return getKey(map,num);
        }
        return 'K';
    }

    public static int[] findTwoNums(int[] arr, int target){

        int[] numArr=new int[2];
        HashMap<Integer, Integer> map= (HashMap<Integer, Integer>) arrayToMap(arr);
        int secondNum=findSecondNum(arr, map, target);
        int firstNum=target-secondNum;
        numArr[0]=firstNum;
        numArr[1]=secondNum;
        return numArr;
    }

}
