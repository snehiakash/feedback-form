package com.thinkconstructive.rest_demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkconstructive.rest_demo.model.CloudVendor;
import com.thinkconstructive.rest_demo.repository.CloudVendorRepository;
import com.thinkconstructive.rest_demo.response.ResponseHandler;
import com.thinkconstructive.rest_demo.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	
	CloudVendorService cloudVendorService;
	
    public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}
    //Read Specific Cloud Vendor Details.
	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
	return	ResponseHandler.responseBuilder("Requested Vendor Details are given Here",
				HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId) );
	
				/*new CloudVendor("C1","Vendor 1","Address One","xxxx");*/
	}
	//Read All Cloud Vendor Details.
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() {
		
	 return cloudVendorService.getAllCloudVendors();
				/*new CloudVendor("C1","Vendor 1","Address One","xxxx");*/
	}
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
    	cloudVendorService.createCloudVendor(cloudVendor);
    	return "Cloud Vendor Created Successfully";
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
    	cloudVendorService.updateCloudVendor(cloudVendor);
    	return "Cloud Vendor Updated Successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
    	cloudVendorService.deleteCloudVendor(vendorId);
    	return "Cloud Vendor Deleted Successfully";
    }
}
