/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.login;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author vitor
 */
public class JPAUtil {
      private static EntityManagerFactory emf;
  public static EntityManager getEntityManager() {
      
      
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("LoginPU");
            }
            return emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace(); // 🔥 mostra erro real
            throw new RuntimeException("Erro ao conectar com o banco");
        }
    }

}

