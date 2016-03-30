// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private boolean peekFlag;
    private Integer peekNumber;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!peekFlag){
            peekNumber = iterator.next();
            peekFlag = true;
        }
        return peekNumber;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!peekFlag){
	        return iterator.next();
	    }
	    Integer res = peekNumber;
	    peekFlag = false;
	    peekNumber = null;
	    return res;
	}

	@Override
	public boolean hasNext() {
	   return peekFlag || iterator.hasNext();
	}
}
