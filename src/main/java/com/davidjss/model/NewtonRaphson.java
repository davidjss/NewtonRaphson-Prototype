package com.davidjss.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewtonRaphson {
    private String valX;
    private String valY;
    private String ValZ;
    private String h1;
    private String h2;
    private String h3;
    private String f1;
    private String f2;
    private String f3;
    private List<String> fuiciones = new ArrayList<>();
    private String matrizDervida[][] = new String[3][3];
    private double matrizDerivdaVal[][] = new double[3][3];
    private List<Arrays> arraysList = new ArrayList<>();

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getValX() {
        return valX;
    }

    public void setValX(String valX) {
        this.valX = valX;
    }

    public String getValY() {
        return valY;
    }

    public void setValY(String valY) {
        this.valY = valY;
    }

    public String getValZ() {
        return ValZ;
    }

    public void setValZ(String valZ) {
        ValZ = valZ;
    }

    public List<String> getFuiciones() {
        return fuiciones;
    }

    public void setFuiciones(List<String> fuiciones) {
        this.fuiciones = fuiciones;
    }

    public String[][] getMatrizDervida() {
        return matrizDervida;
    }

    public void setMatrizDervida(String[][] matrizDervida) {
        this.matrizDervida = matrizDervida;
    }

    public double[][] getMatrizDerivdaVal() {
        return matrizDerivdaVal;
    }

    public void setMatrizDerivdaVal(double[][] matrizDerivdaVal) {
        this.matrizDerivdaVal = matrizDerivdaVal;
    }

    public List<Arrays> getArraysList() {
        return arraysList;
    }

    public void setArraysList(List<Arrays> arraysList) {
        this.arraysList = arraysList;
    }

    public String[][] formarMatrizDerivada(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0){
                    Derivada derivada = new Derivada();
                    derivada.setFuncion(getFuiciones().get( i ));
                    derivada.derivar( "x" );
                    getMatrizDervida()[i][j] = derivada.getFuncion();
                }
                if (j == 1){
                    Derivada derivada = new Derivada();
                    derivada.setFuncion(getFuiciones().get( i ));
                    derivada.derivar( "y" );
                    getMatrizDervida()[i][j] = derivada.getFuncion();
                }
                if (j == 2){
                    Derivada derivada = new Derivada();
                    derivada.setFuncion(getFuiciones().get( i ));
                    derivada.derivar( "z" );
                    getMatrizDervida()[i][j] = derivada.getFuncion();
                }
            }
        }
        setMatrizDervida( getMatrizDervida() );
        return getMatrizDervida();
    }

    public double[][] formarMatrizDerivadaVal(){
        String funcion;
        Calculer calculer = new Calculer();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                funcion = getMatrizDervida()[i][j];
                funcion = funcion.replace( "x",getValX() );
                funcion = funcion.replace( "y",getValY() );
                funcion = funcion.replace( "z",getValZ() );
                calculer.setScreen( funcion );
                calculer.ejecutarEquation();
                getMatrizDerivdaVal()[i][j] = Double.parseDouble(calculer.getResult());
            }
        }
        setMatrizDerivdaVal( getMatrizDerivdaVal() );
        return getMatrizDerivdaVal();
    }
}
