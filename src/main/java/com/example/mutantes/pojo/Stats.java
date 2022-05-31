package com.example.mutantes.pojo;

public class Stats {
    private double countMuntant;
    private double countHuman;
    private double ratio;

    public Stats(float countMuntant, float countHuman) {
        this.countMuntant = countMuntant;
        this.countHuman = countHuman;
        if(countMuntant>0){
            this.ratio = countMuntant/(countMuntant+countHuman);
        }
    }

    public double getCountMuntant() {
        return countMuntant;
    }

    public void setCountMuntant(float countMuntant) {
        this.countMuntant = countMuntant;
    }

    public double getCountHuman() {
        return countHuman;
    }

    public void setCountHuman(float countHuman) {
        this.countHuman = countHuman;
    }

    public double getRatio() {
        if(countMuntant>0){
            this.ratio = countMuntant/(countMuntant+countHuman);
        }
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

}
