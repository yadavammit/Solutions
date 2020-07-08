class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MergeTwoSortedList {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode sortedListNode = new ListNode();
		ListNode root = sortedListNode;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				sortedListNode.next = new ListNode(l1.val, l1.next);
				sortedListNode = sortedListNode.next;
				l1 = l1.next;
			} else {
				sortedListNode.next = new ListNode(l2.val, l2.next);
				sortedListNode = sortedListNode.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			sortedListNode.next = new ListNode(l1.val, l1.next);
			sortedListNode = sortedListNode.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			sortedListNode.next = new ListNode(l2.val, l2.next);
			sortedListNode = sortedListNode.next;
			l2 = l2.next;
		}

		return root.next;
	}
}
