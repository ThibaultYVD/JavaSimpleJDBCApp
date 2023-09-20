package jdbc;

public interface CRUD {
	
	void SELECT();
	void INSERT();
	void UPDATE(int id);
	void DELETE(int id);

}
