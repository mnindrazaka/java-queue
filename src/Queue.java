import java.lang.reflect.Array;

public class Queue<T> {
    private T[] items;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public Queue(Class<T> clazz, int size) {
        items = (T[]) Array.newInstance(clazz, size);
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new Error("Queue Empty");
        }

        T x = items[front];
        front = (front + 1) % capacity;
        count--;
        return x;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new Error("Queue Overflow");
        }

        rear = (rear + 1) % capacity;
        items[rear] = item;
        count++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new Error("Queue Empty");
        }
        return items[front];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public T[] getQueue(Class<T> clazz) {
        T[] queue = (T[]) Array.newInstance(clazz, count);
        for (int i = front; i <= rear; i++) {
            queue[i] = items[i];
        }
        return queue;
    }
}
