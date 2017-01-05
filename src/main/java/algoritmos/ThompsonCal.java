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
package algoritmos;

import Model.Condicao;
import Model.Fruto;

/**
 *
 * @author Sara Pereira Fernandes
 */
public class ThompsonCal {


    Fruto fruto ;

    public ThompsonCal(Fruto fruto){
        this.fruto = fruto;
    }

    public Fruto getFruto() {
        return fruto;
    }

    public void setFruto(Fruto fruto) {
        this.fruto = fruto;
    }
    double rc;
    public double razaoConversao(){


        try{


        rc = fruto.getR1()*fruto.getCondicao().getAltCmdFruto()*fruto.getCondicao().getVolEspAr()/
                fruto.getCondicao().getFxoArSgm()*fruto.getCondicao().getIntTempo()*fruto.getCondicao().getNumCamadas()*60;

        }
        catch(Exception e){
            System.out.println("Divisor Não pode ser divido por zero!");
        }


        return rc;
    }

    public double calorEspecifico(){// Ok, Funcionando
        double cp;

        cp = (fruto.getCp1() + fruto.getCp2())*fruto.getCondicao().getteorAgua();
        return cp;

    }


    public double calorLatenteDeVaporAguaNoFruto(){
        double hfg = 0;

        hfg = ((fruto.getHfg1() - fruto.getHfg2()) * fruto.getCondicao().getTempeFruto())
                *(fruto.getHfg3()*Math.exp( -fruto.getHfg4()*fruto.getCondicao().getteorAgua()));

        return hfg;
    }

    public double teorDeAguaThompson(){//Xe = Teor de Água de Equilíbrio

        double xe, teste;
        //teste = ((Math.log(1+fruto.getCondicao().getUr()))/(fruto.getCondicao().getTempeFruto()+fruto.getXe2())); Funcionando

        xe = (fruto.getXe1()* (Math.pow((-(Math.log(1+fruto.getCondicao().getUr()))/(fruto.getCondicao().getTempeFruto()+fruto.getXe2())),fruto.getXe3())));

        return  xe;
    }

    public double razaoTeorAqua(){//tratar com try, caso o retorno seja null

        double rx;

//        rx = (this.teorAgua - this.tAguaEqui)/(this.tAguaInl - this.tAguaEqui);
//        return rx;
        rx = (fruto.getCondicao().getteorAgua() - this.teorDeAguaThompson())/(fruto.getCondicao().gettAguaInl() - this.teorDeAguaThompson());
        return rx;


    }



}
