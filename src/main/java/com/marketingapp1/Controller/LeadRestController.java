package com.marketingapp1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp1.Repositories.AllLeadRepository;
import com.marketingapp1.entities.AllLead;

@RestController
@RequestMapping("/api/lead")
public class LeadRestController {

	@Autowired
	private AllLeadRepository leadRepo;
	
	@GetMapping
	public List<AllLead> getAllLeads(){ //http://localhost:8080/api/lead
		List<AllLead> leads = leadRepo.findAll();
		return leads;
		}
	
	@GetMapping("/find/{id}")
	public AllLead getOneLead(@PathVariable("id") long id) {
	Optional<AllLead> findById = leadRepo.findById(id);
	AllLead allLead = findById.get();
		return allLead;
		}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	@PostMapping
	public void saveAllLead(@RequestBody AllLead allLead) {
		leadRepo.save(allLead);
	}
	
	@PutMapping
	public void updateAllLead(@RequestBody AllLead allLead) {
		leadRepo.save(allLead);
	}
}
