package br.senac.sp.servicos;

import br.senac.sp.exceptions.ProdutoException;
import br.senac.sp.db.dao.DaoProduto;
import br.senac.sp.exceptions.DataSourceException;
import br.senac.sp.entidades.Produto;
import br.senac.sp.validador.ValidadorProduto;
import java.util.List;

//Classe de serviço de produto
public class ServiceProduto {

    //Insere um produto na fonte de dados
    public static void cadastrarProduto(Produto produto)
            throws ProdutoException, DataSourceException {

        //Chama o validador para verificar o produto
        ValidadorProduto.validar(produto);

        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoProduto.inserir(produto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um produto na fonte de dados
    public static void atualizarProduto(Produto produto)
            throws ProdutoException, DataSourceException {
        
        //Chama o validador para verificar o produto
        ValidadorProduto.validar(produto);

        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoProduto.atualizar(produto);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um produto por nome na fonte de dados
    public static List<Produto> procurarProduto(String nome)
            throws ProdutoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do mock.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (nome == null || "".equals(nome)) {
                return DaoProduto.listar();
            } else {
                return DaoProduto.procurar(nome);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o produto com ID informado do mock
    public static Produto obterProduto(Integer id)
            throws ProdutoException, DataSourceException {
        try {
            //Retorna o produto obtido com o DAO
            return DaoProduto.obter(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o produto com ID informado do mock
    public static void excluirProduto(Integer id)
            throws ProdutoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do produto informado
            DaoProduto.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}

