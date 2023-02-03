package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Unidade;

public class UnidadeMapper implements RowMapper<Unidade> {

	@Override
	public Unidade mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Unidade(rs.getLong("IDUNIDADE"), rs.getString("UNIDADE"),rs.getString("ABREVIACAO"));
	}

}
