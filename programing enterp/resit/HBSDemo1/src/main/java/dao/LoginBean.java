package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Employee;

@Stateless
public class LoginBean implements ILogin{
	
	@PersistenceContext
	private EntityManager entityManager;

	public Employee authenticate(Employee employee) {
    	// using try-with-resources to avoid closing resources (boiler plate code)
        Employee users = null;
        // Step 1: Establishing a Connection
        
        List<Employee> results = entityManager.createQuery("SELECT t FROM Employee t where t.email = :value1 and t.password = :value2")
                .setParameter("value1", employee.getEmail()).setParameter("value2", employee.getPassword()).getResultList();
        
        if(results!= null && results.size()>0)
        	users = results.get(0);
        
        return users;
    }
	
//	public Employee authenticateByREST(Login login) {
//    	// using try-with-resources to avoid closing resources (boiler plate code)
//        Employee users = null;
//        // Step 1: Establishing a Connection
//        try (Connection connection = DBConnection.getConn();
//
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where email=? and pass=?");) {
//        	preparedStatement.setString(1, login.getUserName());
//        	preparedStatement.setString(2, login.getPass());
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String email = rs.getString("email");
//                String firstname = rs.getString("firstname");
//                String lastname = rs.getString("lastname");
//                String employeetype = rs.getString("employeetype");
//                users = new Employee(id, email, firstname, lastname, employeetype);
//            }
//        } catch (SQLException e) {
//        	e.printStackTrace();
//        }
//        return users;
//    }
	
	
}
