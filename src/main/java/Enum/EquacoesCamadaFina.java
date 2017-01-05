/*
 * The MIT License
 *
 * Copyright 2015 Sara Fernandes.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Enum;


import Model.Fruto;
import Model.ModeloCalculoInterface;
import algoritmos.ThompsonCal;
import com.mysimulador.FXMLControllerFruto;

import static java.lang.Math.*;


/**
 *
 * @author Sara Fernandes
 */
public enum EquacoesCamadaFina {//Classe MODELOS


    Thompson {  // Só com Exponencial - Tem que tratar o Polinomial


//                @Override
//                public double EquacaoCamadaFina(Fruto fruto) {// SEM INCREMENTO DE TEMPO
//
//
//                    ThompsonCal calculoThompson = new ThompsonCal(fruto);
//                    calculoThompson.setFruto(fruto); // fruto que está instanciando
//
//                        Teq = ((CoeficienteA.Exponencial.calcular(fruto) * calculoThompson.razaoTeorAqua()) + (CoeficienteB.Exponencial.calcular(fruto)*(pow(calculoThompson.razaoTeorAqua(), 2))));
//
//
//                    return Teq;
//                }
           },
    Page {
//
//                @Override
//                public double EquacaoCamadaFina(Fruto fruto) {
//
//                    ThompsonCal calculoThompson = new ThompsonCal(fruto);
//                    calculoThompson.setFruto(fruto); // fruto que está instanciando
//
//                    Teq = pow((log(calculoThompson.razaoTeorAqua()) / CoeficienteA.Exponencial.calcular(fruto)), 1 / CoeficienteB.Exponencial.calcular(fruto));
//
//                    return Teq;
//                }
            };

    //double Teq;







}
