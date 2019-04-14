package br.senac.sp.servicos;

import br.senac.sp.db.dao.MockCliente;
import br.senac.sp.exceptions.ClienteException;
import br.senac.sp.exceptions.DataSourceException;
import br.senac.sp.entidades.Cliente;
import br.senac.sp.validador.validadorCliente;
import java.util.List;

/**
 *
 * @author WolfDevelloper
 */
// Posteriormente Substituir por dados Persistentes
public class ServicoCliente {

    /**
     * Insere um Cliente na fonte de dados
     * @param cliente
     * @throws ClienteException
     * @throws DataSourceException 
     */ 
    public static void cadastrarCliente(Cliente cliente) throws ClienteException, DataSourceException {

        // chama o validador para verificar o cliente
        validadorCliente.validar(cliente);

        try {
            // Realiza a chamada de iserção na fonte de dados
            MockCliente.inserir(cliente);

        } catch (Exception e) {
            //Imprime qualquer erro Técnico no console e devolve
            // uma exceção e uma menssagem amigavel a camada de visao
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);

        }

    }
/**
 * Atualiza o cadastro do cliente infomado
 * @param cliente
 * @throws ClienteException
 * @throws DataSourceException 
 */
    public static void atualizarCadastro(Cliente cliente) throws ClienteException, DataSourceException {
        // chama o validados para verificar o cliente
        validadorCliente.validar(cliente);
        try {
            // realiza a chamada de atualização na fonte de dados
            MockCliente.atualizarCliente(cliente);
            return;

        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma menssagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);

        }

    }

 /**
  * Realiza a pesquisa de um cliente pelo nome
  * @param nome
  * @return
  * @throws ClienteException
  * @throws DataSourceException 
  */
    public static List<Cliente> procurarCliente(String nome) throws ClienteException, DataSourceException {
        try {
            // verifica se um parametro de pesquisa não foi infomado.
            //Caso afirmativo, realiza uma listagem simples no banco da dados
            //Caso contrário, relaiza uma pesquisa com o parâmetro
            if (nome == null || "".equals(nome)) {
                return MockCliente.listar();

            } else {
                return MockCliente.procurar(nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    /**
     * Obtem o cliente com o ID informado da fonte de dados
     * @param id
     * @return
     * @throws ClienteException
     * @throws DataSourceException 
     */
    public static Cliente obterCliente(Integer id)
            throws ClienteException, DataSourceException {
        try {
            // Retorna o cliente obtido
            return MockCliente.obter(id);

        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devololve
            //uma exceção e uma mensaagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados");
        }
    }

    /**
     * Exclui umc cliente com ID informado na fonte de dados
     * @param id
     * @throws ClienteException
     * @throws DataSourceException 
     */
    public static void excluirCliente(Integer id) throws ClienteException, DataSourceException {
        try {
            //Solicita a fonte de dados a exclusão do cliente informado
            MockCliente.excluir(id);

        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve 
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
