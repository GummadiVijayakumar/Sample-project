package com.tcs.employess.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeesRestController 
{
	
	/*ArrayList<String> employees = new ArrayList<String>(); */
	
	HashMap<Integer, String> employees = new HashMap<Integer, String>();
	
	
	
	@GetMapping("/allEmployees")
	public HashMap<Integer, String> findAll() 
	{
		/*return cartService.findAll();*/
		
		employees.put(1, "vijay");
		employees.put(2, "soumya");
		employees.put(3, "padma");
		
		return employees ;
	}
	
	@GetMapping("/employee/{employeeId}")
	public String getEmployee(@PathVariable int Id) 
	{
		
		
		if(employees.containsKey(Id) == true)
		{
			String name = employees.get(Id) ;
			return name;
		}
		
		else 
		{
			return "Employee id does not exist "+Id;
		}

	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody HashMap<Integer, String> theEmployee)
	{
		
		employees.putAll(theEmployee);
		
		
		return "Successfully added the employee with Id:"+theEmployee.toString();
		
		
	}
	
	@PutMapping("/employees")
	public String updateEmployee(@RequestBody HashMap<Integer, String> theEmployee) 
	{
		
		int emplkey = 0;
		
		for(Entry<Integer, String> entry: theEmployee.entrySet() )
		{
			if(employees.containsKey(entry.getKey()) == true) {
				emplkey = entry.getKey() ;
		        System.out.println("the given employee key does not exist"+ emplkey);
		       
		      }
		}
		
		employees.replace(emplkey,theEmployee.get(emplkey));
		
		return "Successfully updated the employee with Key :"+emplkey;
		
	}

	@DeleteMapping("/employees/{Id}")
	public String deleteEmployee(@PathVariable int Id) 
	{
		
		if(employees.containsKey(Id) == true)
		{
			employees.remove(Id);
			
			return"Successfully deleted the Employee with Employees ID :"+Id;
		}
		
		else 
		{
			return "Employee id does not exist "+Id;
		}

	}

}
