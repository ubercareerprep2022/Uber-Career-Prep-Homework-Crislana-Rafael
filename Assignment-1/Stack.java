import java.util.ArrayList;
public class Stack {
	ArrayList <Object> stack;
	
	public Stack() { //constructor
		stack = new ArrayList<>(); //initialize a "new stack"
	}
	
	public void push(Object o) {
		//pushes an integer on top of the stack
		stack.add(o);
	}
	
	public Object pop() {
		//removes what is on top of the stack and returns that value to the caller
		
		if(!stack.isEmpty()) {
			Object lastElement =  stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1); //removes the last value in the stack
			return lastElement;
		}
		else {
			return null;
		}
		
	}
	
	public Object top() {
		//looks at the top value, and returns it. Does not manipulate the stack
		Object lastElement = stack.get(stack.size() - 1);
		return lastElement;
	}
	
	public boolean isEmpty() {
		//returns true or false if the stack is empty or not, respectively
		return stack.isEmpty();
	}
	
	public int size() {
		return stack.size();
	}



}

