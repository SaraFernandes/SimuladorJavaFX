/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Fruto;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Contrato de persistência para a entidade <code>Fruto</code>.
 *
 * @author Sara Fernandes
 */
public class FrutoDao implements FrutoDaoInterface {

    /**
     * Faz a inserção ou atualização do frutoo na base de dados.
     *
     * @param fruto
     *
     */
    @Override
    public void addFruto(Fruto fruto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(fruto);
        session.flush();
        tx.commit();
//        Session session = HibernateUtil.getSession();
//        session.beginTransaction().begin();
//        session.saveOrUpdate(fruto);
//        session.getTransaction().commit();
//        session.close();
    }

  

    /**
     * @return Lista com todos os frutos cadastrados no banco de dados.
     */
    @Override
    public List<Fruto> listFrutos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Fruto> list = session.createQuery("SELECT f FROM tblFruto f").list();
        tx.commit();
        return list;

    }

    /**
     * Exclui o registro do fruto na base de dados.
     *
     *
     */
    @Override
    public void removeFruto(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().begin();
        Fruto fruto = (Fruto) session.load(Fruto.class, id);
        session.delete(fruto);
        session.getTransaction().commit();
        session.close();

    }

    @Override
   public void updateFruto(Fruto fruto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().begin();
        session.update(fruto);
        session.getTransaction().commit();
        session.close();
   }

   /**
     * @param id filtro da pesquisa.
     * @return Fruto com filtro no id, caso não exista retorna
     * <code>null</code>.
     */
    @Override
    public Fruto getFruto(Long id) {//Pega Fruto pelo Id
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().begin();
        Fruto fruto = (Fruto) session.get(Fruto.class, id);
        session.close();
        return fruto;
    }
   



}
