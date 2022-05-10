public class SinglyLinkedList {
	
	class Node{
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public Node head;
	

	public SinglyLinkedList() {
		//when we first initialize our linked list the head and tail nodes should be both null to start
		head = null;
		
	}
	
	public void push(Node node) {
		//adds the node to the end of the list
		
		//if linked list is empty the head node equals the node in the parameter
		if(head == null) {
			head = node;
		}
		else {
			Node currNode = head; //start at the head node
			while(currNode.next != null) { 
				currNode = currNode.next;
			}
			currNode.next = node;
			currNode.next.next = null;
		}
	}
	
	public Node pop() {
		//removes the last node at the end of the linked list, returns that data
		Node currNode = head; //again start at the head node
		Node poppedNode;
		while(currNode.next.next != null) {
			currNode = currNode.next;
		}
		poppedNode = currNode.next;
		currNode.next = null;
		
		return poppedNode;
		
	}
	
	public void insert(int index, Node node) {
		//adds a single node containing data to a chosen location in the list. If the index is above the size of the list, do nothing
		int counter = 0;
		Node currNode = head;
		Node insertedNode = node;
		Node tempNode;
		
		if(index <= size() && index == 0) {
			tempNode = head;
			head = node;
			head.next = tempNode;
		}
		
		else {
			if(index <= size() && index != 0) {
				while(counter < index - 1) {
					currNode = currNode.next;
					counter++;
				}
				tempNode = currNode.next;
				currNode.next = insertedNode;
				insertedNode.next = tempNode;	
			}
		}
		
	}
	
	public void remove(int index) {
		//remove/delete a single node at the index location in the list. If the node doesn't exist at the index, do nothing
		int counter = 0;
		Node currNode = head;
		
		if(index < size() && index == 0) {
			head = head.next;
		}
		
		if(index < size() && index != 0) {
			while(counter < index - 1) {
				currNode = currNode.next;
				counter++;
			}
			currNode.next = currNode.next.next;
		}
		
	}
	
	public Node elementAt(int index) {
		//returns a pointer to the node at the index location in the list. If the node doesn't exist at the index, return nil/null
		Node currNode = head;
		int counter = 0;
		//if node at the index is null or the index is out of bounds return null
		if(index + 1 > size()) {
			return null;
		}
		else {
			while (counter < index) {
				currNode = currNode.next;
				counter++;
			}
			//System.out.println(currNode.data); - test to see if we're printing the correct Node value based on given index
			return currNode;
		}
		
	}
	
	public int size() {
		//returns the length of the list
	
		if(head == null) {
			return 0;
		}
		else {
			Node currNode = head;
			int size = 1;
			while(currNode.next != null) {
				currNode = currNode.next;
				size++;
			}
			return size;
		}
	}
	
	public void printList() {
		//returns a string representation of the linked list
		Node currNode = head;
		while(currNode != null) {
			System.out.println(currNode.data);
			currNode = currNode.next;
		}
	}
	
	public boolean hasCycle() {
		Node slowNode = head;
		Node fastNode = head;
		
		while(slowNode != null && fastNode != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			
			if(slowNode == fastNode) {
				return true;
			}
		}
		
		return false;
	}
	
	public SinglyLinkedList reverseLinkedList(SinglyLinkedList input) {
		SinglyLinkedList output = new SinglyLinkedList();
		
		//Iterative Solution
		/*
		Node prev = null;
		Node curr = input.head;
		Node next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		//prev will represent the head of the list
		
		
		while(prev != null) {
			output.push(prev);
			prev = curr;
		}
		
		output.printList();
		*/
		
		
		//Stack Solution - I personally find this method more intuitive
		/*
		Stack box = new Stack();
		Node currNode = input.head;
		
		while(currNode != null) {
			box.push(currNode);
			currNode = currNode.next;
		}
		
		while (!box.isEmpty()) {
			output.push((Node)box.pop());
		}
		output.printList();
		*/
		
		//Recursive Solution
		
		Node currNode = input.head;
		currNode = reverseNode(currNode);
		output.push(currNode);
	
		
		output.printList();
		
		return output;
	}

	private Node reverseNode(Node node) {
		Node currHead;
		
		if(node.next == null) {
			return node;
		}
		
		currHead = reverseNode(node.next);
		
		node.next.next = node;
		node.next = null;
		return currHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list1 = new SinglyLinkedList();
		
		Node one = list1.new Node(1);
		Node two = list1.new Node(2);
		Node three = list1.new Node(3);
		Node four = list1.new Node(4);
		
		list1.push(one);
		list1.push(two);
		list1.push(three);
		list1.push(four);
		
		
		
		list1.reverseLinkedList(list1);
		
		/*Node nine = list1.new Node(9);
		
		System.out.println("Testing push method");
		list1.push(one);
		list1.push(two);
		list1.push(three);
		list1.push(four);
		list1.printList();
		System.out.println();
		
		System.out.println("Testing remove method");
		list1.remove(2);
		list1.printList();
		System.out.println();
		
		System.out.println("Testing insert method");
		list1.insert(0, nine);
		list1.printList();
		System.out.println();
		
		System.out.println("Testing pop method");
		list1.pop();
		list1.printList();
		System.out.println();*/
		
	}
}
