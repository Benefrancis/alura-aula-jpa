package br.com.benefrancis.view;

import br.com.benefrancis.model.entity.Categoria;
import br.com.benefrancis.service.CategoriaService;

import javax.swing.*;

public class CategoriaView {

    CategoriaService service;

    public static Categoria select(Categoria categoria) {
        // @formatter:off
        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null, // componente pai. Como não temos será null
                "Selecione uma categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                CategoriaService.findAll().toArray(), // Número da opção
                categoria == null ? 1 : categoria);
        return ret;
        // @formatter:on
    }

    public static Categoria form() {
        String nome = JOptionPane.showInputDialog("Informe o nome da Categoria");
        return new Categoria(nome);
    }

    public void sucesso() {
        JOptionPane.showMessageDialog(null, "Categoria salva com sucesso!");
    }

    public void sucesso(Categoria categoria) {
        System.out.println(categoria);
        JOptionPane.showMessageDialog(null, "Categoria " + categoria.getNome().toUpperCase() + " salva com sucesso!");
    }
}
