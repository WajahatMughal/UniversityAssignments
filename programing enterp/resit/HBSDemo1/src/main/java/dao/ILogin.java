package dao;

import javax.ejb.Local;

import model.Employee;


@Local
public interface ILogin {

	public Employee authenticate(Employee employee);
}
