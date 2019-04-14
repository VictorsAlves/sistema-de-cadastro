package br.senac.sp.db.dao;

import br.senac.db.connection.utils.ConnectionUtils;
import br.senac.sp.entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Mock de Produto. Realiza operações de mock com o produto. 
public class DaoProduto {

    private static int totalProdutos = 0;
   

    //Insere um produto no mock "produto"
    public static void inserir(Produto produto)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produtos passados como parâmetro
        String sql = "INSERT INTO produto (nomeproduto, descricao,marca, categoria, composicao,dimensoes, quantidade, preco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setString(3, produto.getMarca());
            preparedStatement.setString(4, produto.getCategoria());
            preparedStatement.setString(5, produto.getComposicao());
            preparedStatement.setString(6, produto.getTamanho());
            preparedStatement.setInt(7, produto.getQuantidade());            
            preparedStatement.setDouble(8, produto.getValor());
            

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Realiza a atualização dos dados de um produto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Produto"
    public static void atualizar(Produto produto)
            throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando
        //prepared statement
        String sql = "UPDATE produto SET nomeproduto = ?, descricao = ?, categoria = ?, composicao = ?, marca = ?, dimensoes = ?, preco = ?, quantidade = ? WHERE cod_produto = ?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setString(3, produto.getCategoria());
            preparedStatement.setString(4, produto.getComposicao());
            preparedStatement.setString(5, produto.getMarca());
            preparedStatement.setString(6, produto.getTamanho());
            preparedStatement.setFloat(7, produto.getValor());
            preparedStatement.setInt(8, produto.getQuantidade());
            preparedStatement.setInt(9, produto.getCodigo());

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Realiza a exclusão de um produto no mock, com ID fornecido
    //como parâmetro.A exclusão lógica simplesmente "desliga" o
    //produto, configurando um atributo específico, a ser ignorado
    //em todas as consultas de produto ("enabled").
    public static void excluir(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando
        //prepared statement
        String sql = "DELETE FROM produto WHERE codproduto = ?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"

            preparedStatement.setInt(1, id);

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Lista todos os produtos
    public static List<Produto> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de produtos no banco
        String sql = "SELECT codproduto,nomeproduto, descricao,marca, categoria, composicao,dimensoes, quantidade, preco FROM produto";
        //Lista de produtos de resultado
        List<Produto> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setCodigo(result.getInt(1));
                produto.setNome(result.getString(2));
                produto.setDescricao(result.getString(3));
                produto.setCategoria(result.getString(5));
                produto.setComposicao(result.getString(6));
                produto.setMarca(result.getString(4));
                produto.setTamanho(result.getString(7));
                produto.setValor(result.getFloat(9));
                produto.setQuantidade(result.getInt(8));
                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de produtos do banco de dados
        return listaProdutos;
    }

    //Procura um produto no mock, de acordo com o nome
    //ou com o sobrenome, passado como parâmetro
    public static List<Produto> procurar(String valor)
            throws SQLException, Exception {
        //Monta a string de consulta de produtos no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //nome ou sobrenome (através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). 
        String sql = "SELECT cod_produto,nomeproduto, descricao,marca, categoria, composicao,dimensoes, quantidade, preco FROM produto WHERE preco = ?";
        //Lista de produtos de resultado
        List<Produto> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, valor + "%");

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setCodigo(result.getInt(1));
                produto.setNome(result.getString(2));
                produto.setDescricao(result.getString(3));
                produto.setCategoria(result.getString(5));
                produto.setComposicao(result.getString(6));
                produto.setMarca(result.getString(4));
                produto.setTamanho(result.getString(7));
                produto.setValor(result.getFloat(9));
                produto.setQuantidade(result.getInt(8));

                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de produtos do banco de dados
        return listaProdutos;
    }

    //Obtém um produto da lista
    public static Produto obter(Integer id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado
        String sql = "SELECT cod_produto,nomeproduto, descricao,marca, categoria, composicao,dimensoes, quantidade, preco FROM produto WHERE cod_produto = ?";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, id);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {
                //Cria uma instância de Produto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setCodigo(result.getInt(1));
                produto.setNome(result.getString(2));
                produto.setDescricao(result.getString(3));
                produto.setCategoria(result.getString(5));
                produto.setComposicao(result.getString(6));
                produto.setMarca(result.getString(4));
                produto.setTamanho(result.getString(7));
                produto.setValor(result.getFloat(9));
                produto.setQuantidade(result.getInt(8));

                //Retorna o resultado
                return produto;
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }
}
