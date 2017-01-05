/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Fruto;
import java.util.List;

/**
 *
 * @author Sara Fernandes
 */
public interface FrutoDaoInterface {

    public void addFruto(Fruto fruto);

    public List<Fruto> listFrutos();

    public void removeFruto(Long id);

    public void updateFruto(Fruto fruto);

    public Fruto getFruto(Long id);

}
