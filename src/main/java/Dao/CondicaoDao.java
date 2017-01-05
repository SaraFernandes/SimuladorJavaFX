/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Condicao;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Contrato de persistência para a entidade <code>Fruto</code>.
 *
 * @author Sara Fernandes
 */
public class CondicaoDao implements CondicaoDaoInterface {

    /**
     * Faz a inserção ou atualização do frutoo na base de dados.
     *
     * @param condicao
     *
     */
    @Override
    public void addCondicao(Condicao condicao) {
        if(condicao==null)
            System.out.println("A variavel é null");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(condicao);
        session.flush();
        tx.commit();
        session.close();
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
    public List<Condicao> listCondicoes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Condicao> list = session.createQuery("SELECT c FROM tblCondicao c").list();
        tx.commit();
        return list;

    }

    /**
     * Exclui o registro do fruto na base de dados.
     *
     *
     */
    @Override
    public void removeCondicao(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().begin();
        Condicao condicao = (Condicao) session.load(Condicao.class, id);
        session.delete(condicao);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void updateCondicao(Condicao condicao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().begin();
        session.update(condicao);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * @param id filtro da pesquisa.
     * @return Fruto com filtro no id, caso não exista retorna
     * <code>null</code>.
     */
    @Override
    public Condicao getCondicao(Long id) {//Pega Condicao pelo Id
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().begin();
        Condicao condicao = (Condicao) session.get(Condicao.class, id);
        session.close();
        return condicao;
    }




}
