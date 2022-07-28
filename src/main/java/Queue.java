public class Queue {

    private int size = 0;
    private String[] elements = new  String[10];
    private int front = 0;
    public boolean isEmpty() {
        return size == 0;
    }

    public void join(String value) {
        elements[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public String serve() {
        size--;
        String element = elements[front];
        front++;
        return element;
    }
}
