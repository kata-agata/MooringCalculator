/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trend.mooringcalculator;

/**
 *
 * @author agataj
 */
public final class Barge extends WindAreaObject {

    private static Barge INSTANCE; //barge class is Singleton => only one can exist
    private Double length;
    private Double beam;
    private Double height;
    private Double draught;

    private Barge() {
    }

    public static Barge getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Barge();
        }
        return INSTANCE;
    }

//    public Barge(String name, Double length, Double beam, Double height, Double draught, Double shapeCoef) {
//        super(name, shapeCoef); // contructor from parent
//        this.length = length;
//        this.beam = beam;
//        this.height = height;
//        this.draught = draught;
//        calculateWindAreaT(length, height, draught);
//        calculateWindAreaL(beam, height, draught);
//    }
    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getBeam() {
        return beam;
    }

    public void setBeam(Double beam) {
        this.beam = beam;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDraught() {
        return draught;
    }

    public void setDraught(Double draught) {
        this.draught = draught;
    }

    @Override
    public String toString() {
        return "Barge{" + "name=" + getName() + "length=" + length + ", beam=" + beam + ", height=" + height + ", draught=" + draught + '}';
    }

}
