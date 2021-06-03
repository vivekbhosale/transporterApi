package com.springboot.TransporterAPI.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.TransporterAPI.Entity.Transporter;
import com.springboot.TransporterAPI.Model.PostTransporter;
import com.springboot.TransporterAPI.Model.UpdateTransporter;
import com.springboot.TransporterAPI.Response.TransporterCreateResponse;
import com.springboot.TransporterAPI.Response.TransporterDeleteResponse;
import com.springboot.TransporterAPI.Response.TransporterUpdateResponse;
import com.springboot.TransporterAPI.Services.TransporterService;

@RestController
public class TransporterController {
	
	@Autowired
	private TransporterService service;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to transporterApi...!!!";
	}
	
	@PostMapping("/transporter")
	public TransporterCreateResponse addTransporter(@RequestBody PostTransporter transporter) {
		return service.addTransporter(transporter);
	}
	
	
	@GetMapping("/transporter")
	public List<Transporter> getTransporters(@RequestParam(required = false) Boolean approved, @RequestParam(required = false) Integer pageNo){
		return service.getTransporters(approved, pageNo);
	}
	
	@GetMapping("/transporter/{id}")
	private Transporter getOneTransporter(@PathVariable String id) {
		return service.getOneTransporter(id);
	}
	
	
	@PutMapping("/transporter/{id}")
	public TransporterUpdateResponse updateTransporter(@PathVariable String id, @RequestBody UpdateTransporter transporter){
		return service.updateTransporter(id, transporter);
	}
	
	
	@DeleteMapping("/transporter/{id}")
	public TransporterDeleteResponse deleteTransporter(@PathVariable String id){
		return service.deleteTransporter(id);
	}

}
