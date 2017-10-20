package servers.abstraction.utils;

public interface IRepository<ModelType, KeyType> {
	public void create(ModelType model);
	public ModelType read(KeyType primaryKey);
	public void update(ModelType model);
	public void delete(ModelType model);
}
