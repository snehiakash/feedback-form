package com.thinkconstructive.rest_demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thinkconstructive.rest_demo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.rest_demo.model.CloudVendor;
import com.thinkconstructive.rest_demo.repository.CloudVendorRepository;
import com.thinkconstructive.rest_demo.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{
	
	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		super();
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		//More Business Logic
		cloudVendorRepository.save(cloudVendor);
		return "success";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		//More Business Logic
		cloudVendorRepository.save(cloudVendor);
		return "success";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		//More Business Logic
		cloudVendorRepository.deleteById(cloudVendorId);
		return "success";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		//More Business Logic
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
		throw new CloudVendorNotFoundException("Requested Cloud Vendor Does Not Exist");
		
		return cloudVendorRepository.findById(cloudVendorId).get();
		}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		//More Business Logic
		
		return cloudVendorRepository.findAll();
	}

}
