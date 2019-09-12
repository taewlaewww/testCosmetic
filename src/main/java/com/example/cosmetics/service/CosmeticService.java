package com.example.cosmetics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cosmetics.entity.Cosmetics;
import com.example.cosmetics.repository.CosmeticRepository;

@Service
public class CosmeticService {
	
	@Autowired CosmeticRepository cosmeticRepo;
	
	public List <Cosmetics> getAllCosmetics(){
		return cosmeticRepo.findAll();
	}
	
	public void addCosmetics(Cosmetics cosmetics) {
		cosmeticRepo.save(cosmetics);
	}
	
	public void deleteCosmetics(Long id) {
		cosmeticRepo.deleteById(id);
	}
	
	public void updateCosmetics(Long id, Cosmetics cosmetics) {
		Cosmetics cs = cosmeticRepo.getOne(id);
		cs.setName(cosmetics.getName());
		cs.setAmount(cosmetics.getAmount());
		cosmeticRepo.save(cs);
	}

}
