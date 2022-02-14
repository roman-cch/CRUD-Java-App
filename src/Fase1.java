import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Fase1 {

	public static void main(String[] args) {
		
		try {
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
			
			Statement peticion = (Statement) conexion.createStatement();
			ResultSet rs= (ResultSet)peticion.executeQuery("SELECT * FROM usuarios");
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("id")+" - "+rs.getString("login")+" - "+rs.getString("password"));
			}
			
			
			rs.close();
			peticion.close();
			conexion.close();
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
