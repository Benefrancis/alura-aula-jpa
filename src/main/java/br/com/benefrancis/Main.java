package br.com.benefrancis;

import br.com.benefrancis.model.Opcao;
import br.com.benefrancis.model.entity.Categoria;
import br.com.benefrancis.model.entity.Produto;
import br.com.benefrancis.service.CategoriaService;
import br.com.benefrancis.service.ProdutoService;
import br.com.benefrancis.view.CategoriaView;
import br.com.benefrancis.view.OpcaoView;
import br.com.benefrancis.view.ProdutoView;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Opcao opcao = Opcao.ENCERRAR_SISTEMA;

        List<Categoria> categorias = CategoriaService.findAll();

        do {
            opcao = OpcaoView.getOpcoes();
            switch (opcao) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarproduto();
                case ALTERAR_PRODUTO -> alterarproduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarprodutoporid();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarprodutoporcategoria();
            }
        } while (opcao != Opcao.ENCERRAR_SISTEMA);
    }

    private static void consultarprodutoporcategoria() {
        Categoria categoria = CategoriaView.select(null);
        List<Produto> produtos = ProdutoService.findByCategoria(categoria);
        if (produtos.size() == 0) JOptionPane.showMessageDialog(null, "Produto não encotrado");
        produtos.forEach(System.out::println);
        produtos.forEach(ProdutoView::show);
    }

    private static void consultarprodutoporid() {
        Long id = 0l;
        do {
            try {
                id = Long.parseLong(JOptionPane.showInputDialog("Informe o id do produto"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Id inválido!");
            }
        } while (id <= 0);

        Produto p = ProdutoService.findById(id);
        if (p != null) {
            ProdutoView.show(p);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        }
    }

    private static void alterarproduto() {
        ProdutoService produtoService = new ProdutoService();
        Produto produto = ProdutoView.select();
        ProdutoView.update(produto);
    }

    private static void cadastrarproduto() {
        ProdutoService produtoService = new ProdutoService();
        Produto produto = ProdutoView.build();
        produtoService.save(produto);
        ProdutoView.sucesso(produto);
    }

    public static void cadastrarCategoria() {
        CategoriaService service = new CategoriaService();
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form();
        service.save(categoria);
        view.sucesso(categoria);
    }

}