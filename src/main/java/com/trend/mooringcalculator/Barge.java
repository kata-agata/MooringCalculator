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


public class Barge {


    private Integer id;

    private String name;

    private Double length;

    private Double beam;

    private Double depth;

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

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Barge{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", length='" + length + '\''
                + ", beam=" + beam
                + ", depth=" + depth
                + '}';
    }
}
