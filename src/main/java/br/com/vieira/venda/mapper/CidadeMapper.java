package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Cidade;

public class CidadeMapper implements RowMapper<Cidade> {

	@Override
	public Cidade mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Cidade(rs.getLong("IDCIDADE"), rs.getString("CIDADE"));
	}

}
