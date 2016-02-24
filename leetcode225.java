class MyStack {
    private Deque<Integer> q1 = new ArrayDeque<>();
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.removeLast();
    }

    // Get the top element.
    public int top() {
        return q1.getLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.size() == 0;
    }
}
