/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servicos;

import br.senac.sp.entidades.Venda;
import br.senac.sp.db.dao.DaoVenda;
import br.senac.sp.exceptions.DataSourceException;
import br.senac.sp.exceptions.VendaException;
import br.senac.sp.validador.ValidadorVenda;
import java.util.List;

/**
 *
 * @author eduarda.cdonato
 */
public class ServiceVenda {
    //Insere um venda na fonte de dados
    public static void cadastrarVenda(Venda venda)
            throws VendaException, DataSourceException {

        //Chama o validador para verificar o venda
        ValidadorVenda.validar(venda);

        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoVenda.inserir(venda);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    

    //Realiza a pesquisa de um venda por nome na fonte de dados
    public static List<Venda> procurarVenda(String nome)
            throws VendaException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do mock.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (nome == null || "".equals(nome)) {
                return DaoVenda.listar();
            } else {
                return DaoVenda.procurar(nome);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o venda com ID informado do mock
    public static Venda obterVenda(Integer id)
            throws VendaException, DataSourceException {
        try {
            //Retorna o venda obtido com o DAO
            return DaoVenda.obter(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o venda com ID informado do mock
    public static void excluirVenda(Integer id)
            throws VendaException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do venda informado
            DaoVenda.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
