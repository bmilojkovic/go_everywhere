package servers.abstraction.utils;

import java.sql.SQLException;

import javax.ejb.DuplicateKeyException;

public interface IRepository<ModelType, KeyType> {
	public void create(ModelType model) throws DuplicateKeyException;
	public ModelType read(KeyType primaryKey) throws SQLException;
	public void update(ModelType model);
	public void delete(ModelType model);
}
