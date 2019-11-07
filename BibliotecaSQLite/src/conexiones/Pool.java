package conexiones;

import javax.sql.DataSource;
import org.sqlite.SQLiteDataSource;

public class Pool {
	//Atributos para la conexion de sqlite
	public DataSource dataSource;
    public String dbsqlite = "biblioteca.sqlite";
    public String liteDir = System.getProperty("user.dir")+"/sqlite/";
    public String urllite = "jdbc:sqlite:"+liteDir+dbsqlite;
        
    //Constructor vacio para sqlite
    public Pool() {
    	try {
    		inicializaSQLiteDataSource();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en inicializarDataSource");
		}
    }  
    
    private void inicializaSQLiteDataSource() throws ClassNotFoundException{
    	Class.forName("org.sqlite.JDBC");
        SQLiteDataSource basicDataSource = new SQLiteDataSource();       
        basicDataSource.setUrl(urllite);
        dataSource = basicDataSource;
    }
}
