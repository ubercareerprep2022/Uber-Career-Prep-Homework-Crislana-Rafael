import java.util.ArrayList;
public class Queue {
	ArrayList <Object> list;
	
	public Queue() {
		list = new ArrayList<>();
	}
	
	public void enqueue(Object element) {
		
		list.add(element);
	}
	
	public Object dequeue() {
		//removes an item from the queue
		Object element = list.get(0);
		list.remove(0);
		
		return element;
	}
	
	public Object rear() {
		//returns the item at the end of the queue
		return list.get(list.size()-1);
	}
	
	public Object front() {
		//returns an item at the front of the queue
		return list.get(0);
	}
	
	public int size() {
		//returns the size of the queue
		return list.size();
	}
	
	public boolean isEmpty() {
		//returns whether or not the queue is empty
		
		return list.isEmpty();
	}
	
	

}