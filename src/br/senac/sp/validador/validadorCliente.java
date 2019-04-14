package br.senac.sp.validador;

import br.senac.sp.exceptions.ClienteException;
import br.senac.sp.entidades.Cliente;

/**
 *
 * @author WolfDevelloper
 */
public class validadorCliente {

    public static void validar(Cliente cliente) throws ClienteException { // validação de negocios
        // tratado caso o cliente seja nulo 
        if (cliente == null) {
            throw new ClienteException("Não Foi informado um cliente");

            // tratando se o nome do cliente é nulo ou o campo esteja em branco 
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("É necessário informar um nome do Cliente");
        }
        // tratando caso o sobrenome seja vazio ou nulo
        if (cliente.getSobrenome() == null || "".equals(cliente.getSobrenome())) {

            throw new ClienteException("É necessário informar um sobrenome de Cliente");
        }
        // trantado caso a data de nascimento seja nula
        if (cliente.getDataNascimento() == null) {
            throw new ClienteException("É necessário informar uma Data de Nascimento válida. Valor da idade válido");
        }
        // tratando caso o genero seja nulo ou o campo esteja em branco
        if (cliente.getGenero() == null || "".equals(cliente.getGenero())) {
            throw new ClienteException("É necessário informar um Genero");

        }
        if (cliente.getBairro()== null || "".equals(cliente.getBairro())) {
            throw new ClienteException("É necessário informar um Bairro");

        }
        if (cliente.getCep()== null || "".equals(cliente.getCep())) {
            throw new ClienteException("É necessário informar um CEP");

        }
        if (cliente.getCidade()== null || "".equals(cliente.getCidade())) {
            throw new ClienteException("É necessário informar uma Cidade");

        }
        if (cliente.getComplemento()== null || "".equals(cliente.getComplemento())) {
            throw new ClienteException("É necessário informar um Complemento");

        }
        if (cliente.getCpf()== null || "".equals(cliente.getCpf())) {
            throw new ClienteException("É necessário informar um CPF");

        }
        if (cliente.getEstado()== null || "".equals(cliente.getEstado()) || cliente.getEstado().equals("Estado")) {
            throw new ClienteException("É necessário informar um Estado");

        }
        if (cliente.getRua()== null || "".equals(cliente.getRua())) {
            throw new ClienteException("É necessário informar um Rua");

        }

    }

}
