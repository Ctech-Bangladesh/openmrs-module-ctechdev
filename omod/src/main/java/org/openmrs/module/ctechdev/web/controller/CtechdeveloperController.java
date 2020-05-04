package org.openmrs.module.ctechdev.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.ctechdev.CtechDeveloper;
import org.openmrs.module.ctechdev.api.CtechdevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class CtechdeveloperController {
	
	/**
	 * Logger for this class and subclasses
	 */
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	CtechdevService ctechdevService;
	
	@RequestMapping(value = "/module/ctechdev/listDevelopers", method = RequestMethod.GET)
	public ModelAndView listDevelopers(ModelAndView model) throws IOException {
		List<CtechDeveloper> listDeveloper = ctechdevService.getAllDevelopers();
		if (!listDeveloper.isEmpty()) {
			model.addObject("listDeveloper", listDeveloper);
			model.setViewName("/module/ctechdev/listDevelopers");
			
		} else {
			log.info("No Developer has been registered yet...");
		}
		return model;
	}
	
	@RequestMapping(value = "/module/ctechdev/newDeveloper", method = RequestMethod.GET)
	public ModelAndView newDeveloper(ModelAndView model) {
		CtechDeveloper developer = new CtechDeveloper();
		model.addObject("developer", developer);
		model.setViewName("/module/ctechdev/newDeveloper");
		return model;
	}
	
	@RequestMapping(value = "/module/ctechdev/saveDeveloper", method = RequestMethod.POST)
	public String saveDeveloper(@ModelAttribute("developer") CtechDeveloper developer, BindingResult errors) {
		if (errors.hasErrors()) {
			log.info("Errors" + errors);
		}
		this.ctechdevService.saveDeveloper(developer);
		return "redirect:/module/ctechdev/listDevelopers.form";
	}
	
	@RequestMapping(value = "/module/ctechdev/deleteDeveloper/{id}", method = RequestMethod.GET)
	public String deleteDeveloper(@PathVariable("id") Integer id) {
		this.ctechdevService.deleteDeveloper(id);
		return "redirect:/module/ctechdev/listDevelopers.form";
	}
	
	@RequestMapping(value = "/module/ctechdev/editDeveloper/{id}", method = RequestMethod.GET)
	public ModelAndView editDeveloper(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("/module/ctechdev/editDeveloper");
		CtechDeveloper developer = ctechdevService.getDeveloperById(id);
		model.addObject("developer", developer);
		return model;
	}
	
	@RequestMapping(value = "/module/ctechdev/editDeveloper/updateDeveloper", method = RequestMethod.POST)
	public String updateDeveloper(@ModelAttribute("developer") CtechDeveloper developer, BindingResult errors) {
		if (errors.hasErrors()) {
			log.info("Errors" + errors);
		}
		this.ctechdevService.updateDeveloper(developer);
		return "redirect:/module/ctechdev/listDevelopers.form";
	}
}
