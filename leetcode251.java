public class Vector2D implements Iterator<Integer> {
    Queue<Iterator<Integer>> queue;
    Iterator<Integer> current;

    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        for(List<Integer> list : vec2d){
          if(!list.isEmpty()){
            queue.add(list.iterator());
          }
        }
        current = queue.poll();
    }

    @Override
    public Integer next() {
        if(!current.hasNext())
            return -1;
        return current.next();
    }

    @Override
    public boolean hasNext() {
        if(current == null)
            return false;
        while(!current.hasNext()){
            if(!queue.isEmpty()){
                current = queue.poll();
            }
            else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
