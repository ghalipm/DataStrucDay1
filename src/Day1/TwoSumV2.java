package Day1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * given an int array and a target number,
 * find a pair of numbers to sum up to the target,
 * assuming there is only possible solution
 */

public class TwoSumV2 {

// to avoid n^2 complexity, create a map and keep the array in it.
public static HashMap<Integer, Integer> array2Map(int[] arr) {
    HashMap<Integer, Integer> myMap = new HashMap<>();
    for (int i = 0; i <arr.length ; i++) {
        myMap.put(arr[i],i); // NOT myMap.put(i,arr[i]) !!! It will not work
        // if arr[i] has duplicates, keys must be unique: the assumption only one solution,  avoids it.
    }
    return myMap;
}

// find the index set of a pair nums from map which sums upto target
public static int[] getIndexArr(int[] arr, int target){
    int[] indexArr=new int[2];
    for (int i = 0; i <arr.length ; i++) {

        if(array2Map(arr).containsKey(target-arr[i])){
            indexArr[0]=i;
            indexArr[1]=array2Map(arr).get(target-arr[i]); // map.get(key) gets the value
            break;
        }
    }
    return indexArr;
}

    public static void main(String[] args) {

        int target=9;
        System.out.println("target = " + target);
        //int[] array= {-1,2,5,10,13};
        int[] array= {2,5,10,13,7,11};
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("getIndexArr(array,target) = " + Arrays.toString(getIndexArr(array, target)));
    }

}
