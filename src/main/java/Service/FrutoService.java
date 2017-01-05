/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.FrutoDao;
import Dao.FrutoDaoInterface;
import Model.Fruto;
import java.util.List;

/**FrutoService.java is the concrete implementation of the FrutoService.java interface. It provides a public interface of underlying model objects.
 *
 * @author Sara Fernandes
 */
public class FrutoService implements FrutoServiceInterface{

    private FrutoDaoInterface dao = new FrutoDao();
   
    
    @Override
    public void addFruto(Fruto fruto) {
      dao.addFruto(fruto);
    }

    @Override
    public List<Fruto> listFrutos() {
        return dao.listFrutos();
    }

    @Override
    public void removeFruto(Long id) {
       dao.removeFruto(id);
    }

    @Override
    public void updateFruto(Fruto fruto) {
       dao.updateFruto(fruto);
    }

    @Override
    public Fruto getFruto(Long id) {
      return dao.getFruto(id);
    }
    
}
