/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.login.dao;

import br.com.senac.login.JPAUtil;
import br.com.senac.login.data.Acesso;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author vitor
 */
public class AcessoDAO {
    
    public List<Acesso> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Acesso> lista = em
            .createQuery("FROM Acesso", Acesso.class)
            .getResultList();

        em.close();
        return lista;
    }
}
