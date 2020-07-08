import java.util.HashMap;

class Nod {
	int val;
	Nod next;
	Nod random;

	public Nod(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

class CopyListWithRandomPointer {
	HashMap<Nod, Nod> visitedHash = new HashMap<Nod, Nod>();

	public Nod copyRandomList(Nod head) {
		if (head == null) {
			return null;
		}
		if (this.visitedHash.containsKey(head)) {
			return this.visitedHash.get(head);
		}
		Nod deepCopy = new Nod(head.val);
		visitedHash.put(head, deepCopy);
		deepCopy.next = copyRandomList(head.next);
		deepCopy.random = copyRandomList(head.random);
		return deepCopy;
	}
}
