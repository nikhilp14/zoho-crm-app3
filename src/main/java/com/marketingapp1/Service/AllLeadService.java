package com.marketingapp1.Service;

import java.util.List;

import com.marketingapp1.entities.AllLead;

public interface AllLeadService {

	public void saveOneLead(AllLead lead);

	public List<AllLead> getAllLeads();

	public void deleteLead(long id);

	public AllLead getLeadById(long id);

}
