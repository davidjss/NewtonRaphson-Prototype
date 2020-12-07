package com.davidjss.test;

import com.davidjss.model.CMatrices;
import com.davidjss.model.Derivada;
import com.davidjss.model.NewtonRaphson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add( "x^3+y^3-z^3-129" );
        list.add( "x^2+y^2-z^2-9.75" );
        list.add( "x+y-z-9.49" );

        NewtonRaphson x = new NewtonRaphson();
        x.setFuiciones( list );
        x.setValX( "4" );
        x.setValY( "2" );
        x.setValZ( "-3" );
        x.formarMatrizDerivada();
        x.formarMatrizDerivadaVal();
        for (int i = 0; i < x.getMatrizDervida().length; i++) {
            for (int j = 0; j < x.getMatrizDervida()[i].length; j++) {
                System.out.print(x.getMatrizDervida()[i][j] + " | ");
            }
            System.out.println();
        }
        for (int i = 0; i < x.getMatrizDerivdaVal().length; i++) {
            for (int j = 0; j < x.getMatrizDerivdaVal()[i].length; j++) {
                System.out.print(x.getMatrizDerivdaVal()[i][j] + " | ");
            }
            System.out.println();
        }

        CMatrices matrices = new CMatrices();
        double determinante = matrices.Determinante(0,x.getMatrizDerivdaVal());
        double [][] adjunta=matrices.AdjuntaMatriz( x.getMatrizDerivdaVal() );
        double [][] transpuesta=matrices.TransouestaMatriz( adjunta );

        for (int i = 0; i < transpuesta.length ; i++) {
            for (int j = 0; j <transpuesta.length ; j++) {
                System.out.print((transpuesta[i][j]/determinante)+" | ");
            }
            System.out.println("");
        }

    }
}
