package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Pessoa;

public class PessoaMapper implements RowMapper<Pessoa> {

	@Override
	public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pessoa pessoa = new Pessoa();

		pessoa.setId(rs.getLong("IDPESSOA"));
		pessoa.setPrimeiroNome(rs.getString("PRIMEIRONOME"));
		pessoa.setSegundoNome(rs.getString("SEGUNDONOME"));
		pessoa.setCpf(rs.getString("CPF"));
		pessoa.setEmail(rs.getString("EMAIL"));
		pessoa.setComplemento(rs.getString("COMPLEMENTO"));
		pessoa.setNumero(rs.getString("NUMERO"));
		pessoa.setEndereco(rs.getLong("IDENDERECO_PK"), rs.getString("ENDERECO"), rs.getString("CEP"),
				rs.getLong("IDCIDADE_PK"), rs.getString("CIDADE"), rs.getLong("IDESTADO_PK"), rs.getString("ESTADO"),
				rs.getLong("IDBAIRRO_PK"), rs.getString("BAIRRO"));

		return pessoa;
	}
}
