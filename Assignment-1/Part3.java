public class Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test Cases for Stacks and Queues
		Stack myStack = new Stack(); //instantiation of new Stack class
		myStack.push(42);
		System.out.println("Top of Stack: " + myStack.top());
		System.out.println("Size of Stack: " + myStack.size());
		int popped_value = (int) myStack.pop();
		System.out.println("Popped value: " + popped_value);
		System.out.println("Size of stack: " + myStack.size());
		
		//Stack Tests for Bonus Question #2 - handle any type of object as input type
		Stack intStack = new Stack();
		intStack.push(42);
		System.out.println("Top of Stack: " + intStack.top());
		
		Stack stringStack = new Stack();
		stringStack.push("hello world");
		System.out.println("Top of Stack: " + stringStack.top());
		
		
		//Queue Tests for Bonus Question #1 - handle any type of object as input type
		Queue myQueue = new Queue();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		//myQueue.dequeue();
		//myQueue.dequeue();
		//myQueue.enqueue(4);
		
		System.out.println("Size of queue:" + myQueue.size());
		System.out.println("Front of queue:" + myQueue.front());
		System.out.println("Rear of queue:" + myQueue.rear());
		
		int dequeuedItem = (int) myQueue.dequeue();
		System.out.println("Dequeue item:" + dequeuedItem);
		
		


	}

}