package br.senac.sp.db.dao;

import br.senac.db.connection.utils.ConnectionUtils;
import br.senac.sp.entidades.Produto;
import br.senac.sp.entidades.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoVenda {

    // armazena a lista de Vendas
    private static List<Venda> listaVendas = new ArrayList<Venda>();
    //controle de quantidade de Vendas
    private static int totalVendas = 0;

    public static void inserir(Venda venda)
            throws SQLException, Exception {
        //Monta a string de inserção de um venda no BD,
        //utilizando os dados do vendas passados como parâmetro
        String sql = "INSERT INTO venda (datavenda, cod_item, cod_cliente,valortotal,cnpj) VALUES (?, ?, ?, ?, ?)";
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
            Timestamp t = new Timestamp(venda.getData().getTime());
            preparedStatement.setTimestamp(1, t);
            preparedStatement.setInt(2, venda.getProduto());
            preparedStatement.setInt(3, venda.getCliente());
            preparedStatement.setDouble(4, venda.getValorTotal());
            preparedStatement.setString(5, venda.getCnpj());

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

    /**
     * Realiza A exclusão de um Venda
     *
     * @param id
     * @throws Exception
     */
    public static void excluir(int id) throws SQLException, Exception {
        //Monta a string de atualização do venda no BD, utilizando
        //prepared statement
        String sql = "DELETE FROM venda WHERE numNota = ?";
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

    /**
     * lista todos os Vendas presentes na lista
     *
     * @return
     * @throws Exception
     */
    public static List<Venda> listar()
            throws Exception {
        //Monta a string de listagem de vendas no banco
        String sql = "SELECT  numNota,datavenda, cod_item, cod_cliente,valortotal,cnpj FROM venda";
        //Lista de vendas de resultado
        List<Venda> listaVendas = null;
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
                if (listaVendas == null) {
                    listaVendas = new ArrayList<Venda>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Venda venda = new Venda();
                venda.setCodigo(result.getInt(1));
                Date d = new Date(result.getTimestamp(2).getTime());
                venda.setData(d);
                venda.setCliente(result.getInt(4));
                venda.setProduto(result.getInt(3));
                venda.setValorTotal(result.getDouble(5));
                venda.setCnpj(result.getString(6));

                //Adiciona a instância na lista
                listaVendas.add(venda);
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
        //Retorna a lista de vendas do banco de dados
        return listaVendas;
    }

    /**
     * busca um Venda pelo nome informado ou sobrenome
     *
     * @param nome
     * @return
     * @throws Exception
     */
    public static List<Venda> procurar(String valor)
            throws SQLException, Exception {
        //Monta a string de consulta de vendas no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //nome ou sobrenome (através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). 
        String sql = "SELECT numNota,datavenda, cod_item, cod_cliente,valortotal,cnpj FROM venda WHERE valortotal = ? ";
        //Lista de venda de resultado
        List<Venda> listaVendas = null;
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
                if (listaVendas == null) {
                    listaVendas = new ArrayList<Venda>();
                }
                //Cria uma instância de Venda e popula com os valores do BD
                Venda venda = new Venda();
                venda.setCodigo(result.getInt(1));
                Date d = new Date(result.getTimestamp(2).getTime());
                venda.setData(d);
                venda.setCliente(result.getInt(4));
                venda.setProduto(result.getInt(3));
                venda.setValorTotal(result.getDouble(5));
                venda.setCnpj(result.getString(6));

                //Adiciona a instância na lista
                listaVendas.add(venda);
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
        //Retorna a lista de vendas do banco de dados
        return listaVendas;
    }

    /**
     * Obtem um Venda da lista
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static Venda obter(int id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado
        String sql = "SELECT numNota,datavenda, cod_item, cod_cliente,valortotal,cnpj FROM venda WHERE numNota = ?";

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
                //Cria uma instância de Venda e popula com os valores do BD
                Venda venda = new Venda();
                venda.setCodigo(result.getInt(1));
                Date d = new Date(result.getTimestamp(2).getTime());
                venda.setData(d);
                venda.setCliente(result.getInt(4));
                venda.setProduto(result.getInt(3));
                venda.setValorTotal(result.getDouble(5));
                venda.setCnpj(result.getString(6));

                //Retorna o resultado
                return venda;
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
