package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class ParkingSpotService {
	
	@Autowired
	private ParkingSpotRepository repository;
	
	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpot) {
		return repository.save(parkingSpot);
	}

	public boolean existsByLicensePlateCar(String licensePlateCar) {
		return repository.existsByLicensePlateCar(licensePlateCar);
	}

	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {		
		return repository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	public boolean existsByApartmentAndBlock(String apartment, String block) {	
		return repository.existsByApartmentAndBlock(apartment, block);
	}

	public Page<ParkingSpotModel> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<ParkingSpotModel> findById(UUID id) {
		return repository.findById(id);
	}
	
	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) {
		 repository.deleteById(parkingSpotModel.getId());
		
	}
}
