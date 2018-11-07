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
public class WindAreaObject {
    private Integer id;
    private String name;
    protected Double windAreaT;//protected to access this filed via Barge (child of wao)
    protected Double windAreaL;
    private Double shapeCoef;
    private Double windForceT;
    private Double windForceL;
    
    public WindAreaObject(){     
        this.windForceT=0.0;
        this.windForceL=0.0;
    }
    
    public WindAreaObject(String name, Double shapeCoef){
        this.name=name;
        this.shapeCoef=shapeCoef;
        this.windForceT=0.0;
        this.windForceL=0.0;
    }
    
    public WindAreaObject(String name, Double windAreaT, Double windAreaL, Double shapeCoef){
        this.name=name;
        this.windAreaT=windAreaT;
        this.windAreaL=windAreaL;
        this.shapeCoef=shapeCoef;
        this.windForceT=0.0;
        this.windForceL=0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWindAreaT() {
        return windAreaT;
    }

    public void setWindAreaT(Double windAreaT) {
        this.windAreaT = windAreaT;
    }
    
    public void setWindAreaT() { //overidden in child method
        this.windAreaT = 0.0;
    }
    
    public Double getWindAreaL() {
        return windAreaL;
    }

    public void setWindAreaL(Double windAreaL) {
        this.windAreaL = windAreaL;
    }
    
        public void setWindAreaL() { //overidden in child method
        this.windAreaL = 0.0;
    }
    
  
    public Double getShapeCoef() {
        return shapeCoef;
    }

    public void setShapeCoef(Double shapeCoef) {
        this.shapeCoef = shapeCoef;
    }

    @Override
    public String toString() {
        return "WindAreaObject{" + "name=" + name + ", windAreaT=" + windAreaT + ", windAreaL=" + windAreaL + ", shapeCoef=" + shapeCoef + ", windForceT=" + windForceT + '}';
    }
    
    public Double getWindForceT() {
        return windForceT;
    }

    public void setWindForceT(Double airDensity, Double windVelocity, Double g) {
        this.windForceT = calculateWindForce(airDensity, windVelocity, g, windAreaT);
    }

    public Double getWindForceL() {
        return windForceL;
    }

    public void setWindForceL(Double airDensity, Double windVelocity, Double g) {
        this.windForceL = calculateWindForce(airDensity, windVelocity, g, windAreaL);
    }
    
    
    private Double calculateWindForce(Double airDensity, Double windVelocity, Double g, Double windArea){
        Double force = (0.5*airDensity*shapeCoef*windVelocity*windVelocity)/g*windArea;
        return force;
    }
   
}
