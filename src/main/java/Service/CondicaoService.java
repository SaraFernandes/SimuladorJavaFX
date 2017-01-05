/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.CondicaoDao;
import Dao.CondicaoDaoInterface;
import Model.Condicao;
import java.util.List;

/**FrutoService.java is the concrete implementation of the FrutoService.java interface. It provides a public interface of underlying model objects.
 *
 * @author Sara Fernandes
 */
public class CondicaoService implements CondicaoServiceInterface{

    private CondicaoDaoInterface dao = new CondicaoDao();


    @Override
    public void addCondicao(Condicao condicao) {
        dao.addCondicao(condicao);
    }

    @Override
    public List<Condicao> listCondicoes() {
        return dao.listCondicoes();
    }

    @Override
    public void removeCondicao(Long id) {
        dao.removeCondicao(id);
    }

    @Override
    public void updateCondicao(Condicao condicao) {
        dao.updateCondicao(condicao);
    }

    @Override
    public Condicao getCondicao(Long id) {
        return dao.getCondicao(id);
    }

}

