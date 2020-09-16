package algorithm.basic_algorithm.sort;

/**
 * @author lihaoyu
 * @date 2020/8/16 5:27 下午
 */
public class Temp {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

   // 链表归排
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        // 找中点
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 现在的 slow 是中点， 断掉和后面的指针
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode temp1 = sortList(head);
        ListNode temp2 = sortList(newHead);
        ListNode dummy = new ListNode(0), cur = dummy;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                cur.next = temp1;
                temp1 = temp1.next;
            }else{
                cur.next = temp2;
                temp2 = temp2.next;
            }
            cur = cur.next;
        }
        cur.next = temp1 != null ? temp1 : temp2;
        return dummy.next;
    }



    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1, tempIndex = 0, left = start, right = mid + 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int[] temp = new int[end - start+1];
        while (left <= mid && right <= end)
            temp[tempIndex++] = nums[left] <= nums[right] ? nums[left++] : nums[right++];
        while (left <= mid) temp[tempIndex++] = nums[left++];
        while (right <= end) temp[tempIndex++] = nums[right++];
        System.arraycopy(temp, 0, nums, start, end - start+1);
    }

    public static void main(String[] args) {
        int[] temp = new int[]{5, 3, 1, 8, 6, 3, 0};
        mergeSort(temp, 0, 6);
        for (int i : temp) {
            System.out.print(i + " ");
        }

    }

}
