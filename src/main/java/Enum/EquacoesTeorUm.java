/*
 * The MIT License
 *
 * Copyright 2015 Your Organisation.
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

import javax.swing.JOptionPane;
import Model.Fruto;
import Model.EquacaoCalculoInterface;


/**
 *
 * @author Sara Pereira Fernandes
 */
public enum EquacoesTeorUm implements EquacaoCalculoInterface{

    Henderson {

                @Override
                public double EquacaoTeorUm(Fruto fruto) {

                    xe = Math.pow((Math.log(1 - fruto.getCondicao().getUr())
                            / fruto.getXe1() * fruto.getCondicao().getTempeFruto()), fruto.getXe2());
                    return xe;
                }
            },
    Oswin {

                @Override
                public double EquacaoTeorUm(Fruto fruto) {
                    xe = Math.pow((fruto.getXe1() + fruto.getXe2() * fruto.getCondicao().getTempeFruto()
                            / (1 - fruto.getCondicao().getUr()) / fruto.getCondicao().getUr()), 1 / fruto.getXe3());
                    return xe;
                }
            },
//    Thompson {// Já calcula na Classe ThompsonCal
//
//                @Override
//                public double EquacaoTeorUm(Fruto fruto) {
//
//                    xe = fruto.getXe1() * Math.sqrt(-Math.log(1 + fruto.getCondicao().getUr())
//                            / fruto.getCondicao().getTempeFruto() + fruto.getXe2()
//                    );
//                    return xe;
//
//                }
//            },
    Cavalcanti {
                @Override
                public double EquacaoTeorUm(Fruto fruto) {
                    xe = Math.pow((Math.log(1 - fruto.getCondicao().getUr())
                            / fruto.getXe1() * Math.pow(fruto.getCondicao().getTempeFruto(), fruto.getXe2())), fruto.getXe3());
                    return xe;
                }
            };


    double xe;



}
