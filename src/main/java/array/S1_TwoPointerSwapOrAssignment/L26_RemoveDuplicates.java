package array.S1_TwoPointerSwapOrAssignment;

import java.util.Arrays;

public class L26_RemoveDuplicates {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, 3};
    int len = removeDuplicates(nums);

    System.out.println(len);
    System.out.println(Arrays.toString(nums));

    int[] nums1 = new int[]{1, 2, 3, 4, 4, 5};
    int len1 = removeDuplicates(nums1);
    System.out.println(len1);
    System.out.println(Arrays.toString(nums1));
  }

  /*
  * 需求：
  *  * 排序后的数组
  * Coding
  * 校验：
      -	数字长度
      - 排序后的数组
  * 中间变量：双指针，slow，fast
  * 遍历：for loop
  * 操作：
      - 当 nums[slow] = nums[fast], fast++
      - 当 nums[slow] != nums[fast], nums[slow+1] = nums[fast], fast++, slow++
  * 复杂度分析：
  * 	- 时间复杂度：O(n)
  * 	- 空间复杂度：O(1)
  */
  public static int removeDuplicates(int[] nums) {
    int slow = 0;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[fast] != nums[slow]) {
        nums[slow + 1] = nums[fast];
        slow++;
      }
    }
    return nums.length;
  }
}
