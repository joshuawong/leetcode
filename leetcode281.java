public class ZigzagIterator {
    Iterator<Integer> itV1, itV2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        itV1 = v1.iterator();
        itV2 = v2.iterator();
    }

    public int next() {
        if(itV1.hasNext()){
            Iterator<Integer> tmp = itV1;
            itV1 = itV2;
            itV2 = tmp;
        }
        return itV2.next();
    }

    public boolean hasNext() {
        return itV1.hasNext() || itV2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
