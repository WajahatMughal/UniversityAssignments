package utils;

import model1.Employee;
import model1.EmployeeDTO;
import model1.Hoildayrequest;
import model1.HolidayDTO;
import model1.Person;

public final class ModelMapper {
	
	public static Employee convertDTOtoEmployee(EmployeeDTO employeeDTO) {
    	Employee employee = new Employee();
    	if (employeeDTO.getId() != -1) {
    	     employee.setId(employeeDTO.getId());
    	}
    	employee.setDepartment(employeeDTO.getDepartment().toString());
    	employee.setEmail(employeeDTO.getEmail());
    	employee.setPassword(employeeDTO.getPassword());
    	employee.setJoinDate(employeeDTO.getJoinDate());
    	employee.setNumberOfAllowedLeaves(employeeDTO.getNumberOfAllowedLeaves());
    	employee.setRole(employeeDTO.getRole().toString());
    	Person person = new Person();
    	person.setAddress(employeeDTO.getAddress());
    	person.setDateOFBirth(employeeDTO.getDateOFBirth());
    	person.setName(employeeDTO.getName());
    	person.setPhoneNumber(employeeDTO.getPhoneNumber());
    	person.setPostCode(employeeDTO.getPostCode());
    	employee.setPerson(person);
		return employee;
	}
	
	public static Hoildayrequest convertToHolidayfromDTO(HolidayDTO hoildayDTO) {
		Hoildayrequest hoildayrequest = new Hoildayrequest();
		hoildayrequest.setFromDate(hoildayDTO.getFromDate().getTime());
		hoildayrequest.setToDate(hoildayDTO.getToDate().getTime());
		hoildayrequest.setNumberOfDate(hoildayDTO.getNumberOfDate());
		hoildayrequest.setReason(hoildayDTO.getReason());
		hoildayrequest.setStatus(hoildayDTO.getStatus().toString());
    	if (hoildayDTO.getId() != -1) {
		hoildayrequest.setId(hoildayDTO.getId());
    	}
		hoildayrequest.setEmployee(convertDTOtoEmployee(hoildayDTO.getEmployee()));
		return hoildayrequest;
	}

}
