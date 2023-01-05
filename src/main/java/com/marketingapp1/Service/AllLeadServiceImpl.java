package com.marketingapp1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp1.Repositories.AllLeadRepository;
import com.marketingapp1.entities.AllLead;
@Service
public class AllLeadServiceImpl implements AllLeadService {

	
	@Autowired
	private AllLeadRepository allLeadRepo;
	@Override
	public void saveOneLead(AllLead lead) {
	
		allLeadRepo.save(lead);
	}
	@Override
	public List<AllLead> getAllLeads() {
		List<AllLead> leads = allLeadRepo.findAll();
		return leads;
		
	}
	@Override
	public void deleteLead(long id) {
		allLeadRepo.deleteById(id);
	}
	@Override
	public AllLead getLeadById(long id) {
		Optional<AllLead> findById = allLeadRepo.findById(id);
		AllLead leadss = findById.get();
		return leadss;
	}

}
