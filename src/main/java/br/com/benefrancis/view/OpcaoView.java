package br.com.benefrancis.view;

import br.com.benefrancis.model.Opcao;

import javax.swing.*;

public class OpcaoView {

    public static Opcao getOpcoes() {
        // @formatter:off
        Opcao ret = (Opcao) JOptionPane.showInputDialog(
                null, // componente pai. Como não temos será null
                "Selecione uma opção",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                Opcao.values(), // Número da opção
                Opcao.CADASTRAR_PRODUTO);

        return ret != null ? ret : Opcao.ENCERRAR_SISTEMA;
        // @formatter:on
    }
}
