package com.example.controller;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
//import java.util.Date;
import java.util.List;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.services.EmployeeService;

@RestController
public class Controller {
	
	 @Autowired
	 EmployeeService employeeService;
	 
	 /*@RequestMapping("/")
	 Employee home(Employee employee) {
	  employee = employeeService.create(employee);
	        return employee;
	    }
	 */
	 /* 	@RequestMapping(path="/employee/Insert", method = RequestMethod.POST)
	public void toStore(@RequestBody Employee employee) {
	  * */
		@RequestMapping(path="/studentPostTest",method=RequestMethod.POST)
		public void toTest(@RequestBody String toPostCall) {
			System.out.println("To Console="+toPostCall);
		}
	 @RequestMapping("/employee")
	   public List<Employee> findAllUsers() {
	  List<Employee> employee = employeeService.findAll();
	        return employee;
	    }
	
	@RequestMapping(value="/employee/{SAPID}")
	public Employee IndivisualEmployee(@PathVariable("SAPID") int SAPID){
		return employeeService.findUserById(SAPID);
	}
	@RequestMapping(value="/employee/Yanish")
	public Employee Yanish(){
		return employeeService.findYanish();
	}
	@RequestMapping(value="/employee/CsvToDataBase")
	public void csvToDatabase() {
		StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("mapping.xml");
        
        // use a StreamFactory to create a BeanReader
        BeanReader in = factory.createReader("employeeFile", new File("D:\\Users\\yanish.p\\oxygen-workspace\\EmployeeToDB.csv"));
        Employee employee;
        System.out.println("Working Properly");
        while ((employee = (Employee) in.read()) != null) {
            employeeService.writeTo(employee);
        }
        in.close();
	}
	@RequestMapping(path="/employee/Insert", method = RequestMethod.POST)
	public void toStore(@RequestBody Employee employee) {
		System.out.println("Employee Name:"+employee.getName() +" Designation:"+employee.getDesignation()+" SAPID:"+employee.getSapid());
		
		try{
			employeeService.writeTo(employee);
		}catch(Exception e) {
			System.out.println("Error:"+e.getStackTrace() + " "+ e.getMessage());
		}
	}
	//Sets 200 status
	@RequestMapping("/check")
	public ResponseEntity<String> check() {
		BodyBuilder builder = (BodyBuilder) ResponseEntity.ok();
		builder.allow(HttpMethod.GET);
		builder.contentType(MediaType.TEXT_HTML);
		builder.eTag("W/MyeTag\"");
		return builder.body("Hello World!");
	}
	//Handle Status "Sets the required status using HttpStatus"
	@RequestMapping("/handle/Status")
	public ResponseEntity<String> handleStatus() {
	   return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).body("BANDWIDTH LIMIT EXCEEDED");
	}
	//Sets 201 status. 
	@RequestMapping("/handle")
	public ResponseEntity<Void> handle() {
	    URI location = null;
	    try {
		location = new URI("http://www.google.com/");
	    } catch (URISyntaxException e) {
		e.printStackTrace();
	    }
	    return ResponseEntity.created(location).build();
	} 
	//Sets 202 status. 
	@RequestMapping("/handle/Accepted")
	public ResponseEntity<String> handleAccepted() {
	     return ResponseEntity.accepted().body("Hello World!");
	} 
	//Sets 204 status. 
	@RequestMapping("/handle/NoContent")
	public ResponseEntity<Void> handleNoContent() {
	    return ResponseEntity.noContent().build();
	} 
	//Sets 400 bad request sttaus.
	@RequestMapping("/handle/BadRequest")
	public ResponseEntity<String> handleBadRequest() {
	   return ResponseEntity.badRequest().body("Bad Request");
	} 
	//Sets 404 not found status. 
	@RequestMapping("/handle/notfound")
	public ResponseEntity<Void> handleNotFound() {
		return ResponseEntity.notFound().build();
	} 
	//Sets 422 Unprocessable Entity status. 
	@RequestMapping("/handle/Cannot")
	public ResponseEntity<String> handleCannot() {
		return ResponseEntity.unprocessableEntity().body("Cannot process");
	} 
}
