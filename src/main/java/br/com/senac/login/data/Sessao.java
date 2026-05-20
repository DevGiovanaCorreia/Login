/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.login.data;

import br.com.senac.login.dao.AcessoDAO;
import java.util.List;

/**
 *
 * @author vitor
 */
public class Sessao {

    private static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    // logout
    public static void encerrarSessao() {
        usuarioLogado = null;
    }
}

