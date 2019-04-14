package br.senac.db.connection.utils;

import java.sql.*;
import javax.swing.JOptionPane;

/*
*esta entidade tem como objetivo estabelecer conexao com o banco de dados
*/

public class ConnectionUtils {
// conector

    //conexao com o host do banco de dados
    public static Connection getConnection() {
        java.sql.Connection conexao = null;

        //dados da conta do banco de dados
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cmb?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "";

        try {
            //referencia ao driver
            Class.forName(driver);
            //verificação da conta
            conexao = DriverManager.getConnection(url, user, password);
            // retorno da conexao
            return conexao;
        } catch (Exception e) {
            //mensagem de erro
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}