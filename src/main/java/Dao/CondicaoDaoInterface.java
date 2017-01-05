/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Condicao;



import java.util.List;

/**
 *
 * @author Sara Fernandes
 */
public interface CondicaoDaoInterface {

    public void addCondicao(Condicao condicao);

    public List<Condicao> listCondicoes();

    public void removeCondicao(Long id);

    public void updateCondicao(Condicao condicao);

    public Condicao getCondicao(Long id);

}
