package com.marketingapp1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp1.Service.AllLeadService;
import com.marketingapp1.dto.LeadData;
import com.marketingapp1.entities.AllLead;
import com.marketingapp1.util.EmailService;

@Controller
public class LeadController {
	@Autowired
	private AllLeadService allLeadService;
	
	@Autowired
	private EmailService emailService;
	//Handler Method
	//http://localhost:8080/create

	@RequestMapping("/create")
	public String viewLeadCreateForm() {
		return "createLead";
	}
	
	//http://localhost:8080/saveAllLead
	@RequestMapping("/saveAllLead")
	public String saveOneLead(@ModelAttribute("lead")AllLead lead,ModelMap model) {
		model.addAttribute("msg", "Record is being saved!!@");
		emailService.sendEmail(lead.getEmail(),"Wellcome","Hello World");
		allLeadService.saveOneLead(lead);
		return"createLead";
	}
//	//http://localhost:8080/saveAllLead
//	@RequestMapping("/saveAllLead")
//	public String saveOneLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("mobile") long mobile) {
//		AllLead lead = new AllLead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		allLeadService.saveOneLead(lead);
//		return "createLead";
//	}
//	@RequestMapping("/saveAllLead")
//	public String saveOneLead(LeadData leadData ) {
//		AllLead lead = new AllLead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());
//		allLeadService.saveOneLead(lead);
//		return"createLead";
//	}
	//http://localhost:8080/listAll
	@RequestMapping("/listAll")
	public String listAllLead(ModelMap model) {
		List<AllLead> leads = allLeadService.getAllLeads();
		model.addAttribute("leads", leads);
	
		return "list_leads";
		
	}
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, ModelMap model) {
		allLeadService.deleteLead(id);
		
		List<AllLead> leads = allLeadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id,Model model) {
		AllLead leadss = allLeadService.getLeadById(id);
		model.addAttribute("leadss", leadss);
		return "update_lead";
		}
	
	@RequestMapping("/updateAllLead")
	public String updateOneLead(@ModelAttribute("lead")AllLead lead,ModelMap model) {
		allLeadService.saveOneLead(lead);
		List<AllLead> leads = allLeadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
		
		
	}
}
