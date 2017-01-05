/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Condicao;

import java.util.List;

/**The ContactService.java interface provides cohesive, high-level logic for related parts of the application. This layer is invoked directly by the Controller and View layers. 
 *
 * @author Sara Fernandes
 */
public interface CondicaoServiceInterface {
    
   public void addCondicao(Condicao condicao);

    public List<Condicao> listCondicoes();

    public void removeCondicao(Long id);

    public void updateCondicao(Condicao condicao);
    
    public Condicao getCondicao(Long id);
    
}
