package servers.abstraction.utils;

import java.sql.SQLException;

import javax.ejb.DuplicateKeyException;

public interface IRepository<ModelType, KeyType> {
	public void create(ModelType model) throws DuplicateKeyException, SQLException;
	public ModelType read(KeyType primaryKey) throws SQLException;
	public void update(ModelType model) throws SQLException;
	public void delete(ModelType model) throws SQLException;
}
