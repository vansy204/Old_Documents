package java_84.model;

/**
 * MiniCaculator
 */
public class MiniCaculatorModel {
    private double firstVal ;
    private double secondVal;
    private double answer;

    public MiniCaculatorModel(double firstVal, double secondVal,double answer) {
        this.firstVal = firstVal;
        this.secondVal = secondVal;
        this.answer = answer;
    }

    public MiniCaculatorModel() {
    }

    public double getFirstVal() {
        return this.firstVal;
    }

    public void setFirstVal(double firstVal) {
        this.firstVal = firstVal;
    }

    public double getSecondVal() {
        return this.secondVal;
    }

    public void setSecondVal(double secondVal) {
        this.secondVal = secondVal;
    }


    public double getAnswer() {
        return this.answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }
    public void plus(){
        this.answer = this.firstVal + this.secondVal;
    }
    public void minus(){
        this.answer = this.firstVal - secondVal;
    }
    public void multiply(){
        this.answer = this.firstVal * this.secondVal;
    }
    public void divide(){
        this.answer = this.firstVal / this.secondVal;
    }
    public void pow(){
        this.answer = Math.pow(this.firstVal,this.secondVal );
    }
    public void mod(){
        this.answer = this.firstVal % this.secondVal;
    }


}