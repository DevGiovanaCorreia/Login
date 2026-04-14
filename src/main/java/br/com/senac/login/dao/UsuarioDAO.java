/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.login.dao;

import br.com.senac.login.JPAUtil;
import br.com.senac.login.data.Usuario;
import jakarta.persistence.EntityManager;
import java.util.List;


public class UsuarioDAO {
    
    public void cadastrar(Usuario usuario){
        EntityManager em = JPAUtil.getEntityManager();
        
        
        try{
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.clear();
        }
    }
    
    public List<Usuario> listarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        
        List<Usuario> lista = em.createQuery(
                "FROM USUARIO",
                Usuario.class).getResultList();
        em.close();
        return lista;
    }
    
     public Usuario buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Usuario usuario = em.find(Usuario.class, id);

        em.close();
        return usuario;
    }

    
    public void atualizar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    public void deletar(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Usuario usuario = em.find(Usuario.class, id);

        if (usuario != null) {
            try {
                em.getTransaction().begin();
                em.remove(usuario);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
        }

        em.close();
    }
    
   public Usuario buscarPorEmail(String email) {
    EntityManager em = JPAUtil.getEntityManager();

    try {
        return em.createQuery(
            "SELECT u FROM Usuario u WHERE u.email = :email",
            Usuario.class
        )
        .setParameter("email", email)
        .getSingleResult();

    } catch (Exception e) {
        return null;
    } finally {
        em.close();
    }
}
}
