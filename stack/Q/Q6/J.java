public class J {

    int[] queue;
    int front;
    int rear;
    int size;

    public J(int k) {
        queue = new int[k];
        front = -1;
        rear = -1;
        size = k;
    }

    public boolean enQueue(int value) {

        // Queue full
        if ((rear + 1) % size == front) {
            return false;
        }

        // First element
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {

        // Queue empty
        if (front == -1) {
            return false;
        }

        // Only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return true;
    }

    public int Front() {

        if (front == -1) {
    }
}
