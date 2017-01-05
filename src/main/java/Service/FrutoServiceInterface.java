/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Fruto;
import java.util.List;

/**The ContactService.java interface provides cohesive, high-level logic for related parts of the application. This layer is invoked directly by the Controller and View layers. 
 *
 * @author Sara Fernandes
 */
public interface FrutoServiceInterface {
    
   public void addFruto(Fruto fruto);

    public List<Fruto> listFrutos();

    public void removeFruto(Long id);

    public void updateFruto(Fruto fruto);
    
    public Fruto getFruto(Long id);
    
}
