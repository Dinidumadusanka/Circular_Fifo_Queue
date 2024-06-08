package circularFifoQueue;

public class CircularFifoQueue_ii {
	
	    private int[] queue;
	    private int front; 
	    private int rear; 
	    private int size; 
	    private int capacity; 

	    // Constructor to initialize the queue
	    public CircularFifoQueue_ii(int capacity) {
	        this.capacity = capacity;
	        queue = new int[capacity];
	        front = 0;
	        rear = -1;
	        size = 0;
	    }

	    // Method to enqueue an element into the queue
	    public void enqueue(int item) {
	        if (isFull()) {
	            System.out.println("Queue is full. Cannot enqueue.");
	            return;
	        }
	        rear = (rear + 1) % capacity;
	        queue[rear] = item;
	        size++;
	    }

	    // Method to dequeue an element from the queue
	    public int dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty. Cannot dequeue.");
	            return -1;
	        }
	        int item = queue[front];
	        front = (front + 1) % capacity;
	        size--;
	        return item;
	    }

	    // Method to check if the queue is empty
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    // Method to check if the queue is full
	    public boolean isFull() {
	        return size == capacity;
	    }

	    // Method to get the front element of the queue without dequeueing
	    public int peek() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty. Cannot peek.");
	            return -1;
	        }
	        return queue[front];
	    }

	    // Method to get the size of the queue
	    public int size() {
	        return size;
	    }

	    // Method to display the elements of the queue
	    public void display() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty.");
	            return;
	        }
	        System.out.print("Queue: ");
	        int count = 0;
	        int index = front;
	        while (count < size) {
	            System.out.print(queue[index] + " ");
	            index = (index + 1) % capacity;
	            count++;
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        CircularFifoQueue_ii queue = new CircularFifoQueue_ii(5);

	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);
	        queue.enqueue(40);
	        queue.enqueue(50);

	        queue.display(); 
	        System.out.println("Dequeued item: " + queue.dequeue()); 
	        System.out.println("Dequeued item: " + queue.dequeue()); 

	        queue.display(); 

	        System.out.println("Front element: " + queue.peek());
	    }
	}


