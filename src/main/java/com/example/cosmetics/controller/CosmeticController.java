package com.example.cosmetics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cosmetics.entity.Cosmetics;
import com.example.cosmetics.repository.CosmeticRepository;
import com.example.cosmetics.service.CosmeticService;

//@RestController
@Controller
public class CosmeticController {
	
	@Autowired 
	CosmeticService cosmeticService;
	
/*	@GetMapping("/cosmetics")
	public List <Cosmetics> selectAllCosmetics() {
		return cosmeticService.getAllCosmetics();
	}
	
	@RequestMapping(value = "/cosmetics", method=RequestMethod.POST)
	public void addCosmetics(@RequestBody Cosmetics cosmetics){
		cosmeticService.addCosmetics(cosmetics);
	}
	
	@RequestMapping(value = "/cosmetics/{id}", method=RequestMethod.DELETE)
	public void addCosmetics(@PathVariable Long id){
		cosmeticService.deleteCosmetics(id);
	}
	
	@RequestMapping(value = "/cosmetics/{id}", method=RequestMethod.POST)
	public void updateCosmetics(@PathVariable Long id, @RequestBody Cosmetics cosmetics){
		cosmeticService.updateCosmetics(id, cosmetics);
	}*/
	
	
	@GetMapping("/cosmetics")
	public String cosmetic (final Model model){
		List<Cosmetics> cosmeticList = cosmeticService.getAllCosmetics();		
		model.addAttribute("cosmetics", cosmeticList);
		return "cosmetics";
	}
	
	@RequestMapping(value = "/cosmetics", method=RequestMethod.POST)
	public String addCosmetics(@ModelAttribute("cosmetics")Cosmetics cosmetics){
		cosmeticService.addCosmetics(cosmetics);
		return "redirect:/cosmetics";   
	}
	
	
	@RequestMapping(value = "/delcosmetics/{id}", method=RequestMethod.GET)
	public String deleteCosmetics(@PathVariable Long id){
		cosmeticService.deleteCosmetics(id);
		return "redirect:/cosmetics";
	}
	
		
}
