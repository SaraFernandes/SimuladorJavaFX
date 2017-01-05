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

import Model.Condicao;
import Model.EquacaoCamFinaInterface;
import Model.Fruto;

/**
 *
 * @author Sara Pereira Fernandes
 */
public enum CoeficienteB implements EquacaoCamFinaInterface {

    Polinomial {// OK Funcionando

                @Override
                public double calcular(Fruto fruto) {
                    double b;
                    b = (fruto.getB1() + (fruto.getB2() * fruto.getCondicao().getTempeFruto()) + (fruto.getB3() * Math.pow(fruto.getCondicao().getTempeFruto(), 2)) + (fruto.getB4() * Math.pow(fruto.getCondicao().getTempeFruto(), 3))
                    + (fruto.getB5() * Math.pow(fruto.getCondicao().getTempeFruto(), 4)) + (fruto.getB6() * Math.pow(fruto.getCondicao().getTempeFruto(), 5)) + (fruto.getB7() * Math.pow(fruto.getCondicao().getTempeFruto(), 6))
                    + (fruto.getB8() * Math.pow(fruto.getCondicao().getTempeFruto(), 7)));
                    return b;
                }
            },
    Exponencial {// OK Funcionando

                @Override
                public double calcular(Fruto fruto) {
                    double b;
                    b = fruto.getB1() + Math.exp(-fruto.getB2() * fruto.getCondicao().getTempeFruto());
                    return b;
                }

            };

}
