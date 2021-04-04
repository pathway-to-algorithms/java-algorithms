package array.S1_TwoPointerSwapOrAssignment;


import java.util.Arrays;

public class L27_RemoveElement {

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 2, 3};
    int len = removeElement(nums, 3);

    System.out.println(len);
    System.out.println(Arrays.toString(nums));

    int[] nums1 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    int len1 = removeElement(nums1, 2);

    System.out.println(len1);
    System.out.println(Arrays.toString(nums1));

  }

  public static int removeElement(int[] nums, int val) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
    }
    return slow;
  }

}
