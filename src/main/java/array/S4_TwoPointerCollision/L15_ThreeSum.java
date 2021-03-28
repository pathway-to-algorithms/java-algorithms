package array.S4_TwoPointerCollision;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_ThreeSum {

  public static void main(String[] args) {
    List<List<Integer>> ans = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    System.out.println(ans);
  }

  /*
   *
   */
  private static List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();

    int l = nums.length;
    for (int i = 0; i < l; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int right = l - 1;
      int target = -1 * nums[i];

      for (int left = i + 1; left < l; left++) {
        if (left > i + 1 && nums[left] == nums[left - 1]) {
          continue;
        }

        if (left < right && nums[left] + nums[right] > target) {
          --right;
        }

        if (left == right) {
          break;
        }

        if (nums[left] + nums[right] == target) {
          List<Integer> pair = new ArrayList<>();
          pair.add(nums[i]);
          pair.add(nums[left]);
          pair.add(nums[right]);
          ans.add(pair);
        }

      }
    }
    return ans;
  }
}
