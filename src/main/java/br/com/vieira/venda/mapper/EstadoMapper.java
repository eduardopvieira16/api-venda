package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Estado;

public class EstadoMapper implements RowMapper<Estado> {

	@Override
	public Estado mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Estado(rs.getLong("IDESTADO"), rs.getString("ESTADO"));
	}

}
