package java_81.model;

/**
 * CounterModel
 */
public class CounterModel {
    private int val;

    public CounterModel() {
        this.val = 0;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void incresment() {
        this.val += 1;
    }

    public void decrement() {
        this.val -= 1;
    }

    public void reset() {
        this.val = 0;
    }
}
