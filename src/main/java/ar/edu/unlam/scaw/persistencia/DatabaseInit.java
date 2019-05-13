package ar.edu.unlam.scaw.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.unlam.scaw.modelo.Texto;
import ar.edu.unlam.scaw.modelo.Usuario;
public class DatabaseInit {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM TEXTO");
	        ResultSet rs = ps.executeQuery();
	        
	        List<Usuario> lu = new ArrayList<Usuario>();
	        while (rs.next()) {
	        	int id = rs.getInt("id");
	        	String desc = rs.getString("descripcion");
	        	Texto u = new Texto();
	        	u.setId(id);
	        	u.setDescripcion(desc);
	        	System.out.println("lista de usuarios de la db");
		        System.out.println(u.getDescripcion());
			}
	        
	        ((ConfigurableApplicationContext) context).close();
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        List<Employee> empList = new ArrayList<Employee>();
//        while(rs.next()) {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            Employee emp = new Employee();
//            emp.setId(id);
//            emp.setName(name);
//            empList.add(emp);            
//        }
//        System.out.println(empList);
//        ((ConfigurableApplicationContext) context).close();
	}

}
