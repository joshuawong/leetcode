public class MovingAverage {
    private double sum;
    private List<Integer> list;
    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.sum = 0.0;
        this.size = size;
        this.list = new ArrayList<>();
    }

    public double next(int val) {
        if(list.size() < size){
            sum += val;
        }
        else{
            int tmp = list.remove(0);
            sum += val - tmp;
        }
        list.add(val);
        return sum / list.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
