
import java.util.HashMap;

public class Question4 {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix sum occurs once
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int required = prefixSum - k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            // Store frequency of current prefix sum
            if (map.containsKey(prefixSum)) {
                map.put(
                    prefixSum,
                    map.get(prefixSum) + 1
                );
            } else {
                map.put(prefixSum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }
}