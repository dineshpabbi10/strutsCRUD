package org.employee.crud.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.employee.crud.models.Employees;
import org.employee.crud.models.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeesCRUD extends ActionSupport implements ModelDriven<List<Employees>>  {
	
	public List<Employees> employees = new ArrayList<Employees>();
	public boolean isDeleted;
	public Employees emp = new Employees();
	
	public String getAllEmployees() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tiffinpass");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from employee");
			while(rs.next()) {
				Employees u = new Employees();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setSalary(rs.getInt("salary"));
				employees.add(u);
				
			}
			return SUCCESS;
		}catch(Exception e) {
			return ERROR;
		}
	}
	
	public String deleteEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tiffinpass");
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM employee where id = ?");
			stmt.setInt(1, this.emp.getId());;
			stmt.executeUpdate();
			return SUCCESS;
		}catch(Exception e) {
			return ERROR;
		}
	}
	
	public String editEmployee() throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tiffinpass");
			PreparedStatement stmt = conn.prepareStatement("Select * FROM employee where id = ?");
			System.out.print("HellO"+this.emp.getId());
			stmt.setInt(1, this.emp.getId());
			ResultSet rs = stmt.executeQuery();
			rs.next();
			this.emp.setId(rs.getInt("id"));
			this.emp.setEmail(rs.getString("email"));
			this.emp.setName(rs.getString("name"));
			this.emp.setSalary(rs.getInt("salary"));
			return SUCCESS;
			
	}
	
	public String updateEmployee() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tiffinpass");
		String up = "UPDATE EMPLOYEE SET name = ?,email = ?,salary=? WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(up);
		stmt.setString(1,this.emp.name);
		stmt.setString(2, this.emp.email);
		stmt.setInt(3, this.emp.salary);
		stmt.setInt(4, this.emp.id);
		stmt.executeUpdate();
		return SUCCESS;
	}
	
	public List<Employees> getModel(){
		return employees;
	}
	
}
