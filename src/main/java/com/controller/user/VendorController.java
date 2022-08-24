package com.controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.VendorBean;
import com.repository.VendorRepository;

@RestController
@RequestMapping("/user")
public class VendorController {

	@Autowired
	VendorRepository vendorRepo;

	@PostMapping("vendor")
	public ResponseEntity<?> addVendor(@RequestBody VendorBean vendor) {
		// db save
		// dao -> repo -> interface
		vendorRepo.save(vendor);
		return ResponseEntity.ok(vendor);
	}

	@GetMapping("vendor")
	public ResponseEntity<?> getAllVendor() {
		List<VendorBean> vendors = vendorRepo.findAll();// select *
		return ResponseEntity.ok(vendors);
	}

	@GetMapping("vendor/{vendorId}")
	public ResponseEntity<?> getVendorById(@PathVariable("vendorId") Integer vendorId) {
		Optional<VendorBean> op = vendorRepo.findById(vendorId);
		if (op.isPresent()) {
			return ResponseEntity.ok(op.get());// 200
		} else {
			return ResponseEntity.badRequest().build();// 401
		}
	}

	@DeleteMapping("vendor/{vendorId}")
	public ResponseEntity<?> deleteVendorById(@PathVariable("vendorId") Integer vendorId) {
		Optional<VendorBean> op = vendorRepo.findById(vendorId);
		if (op.isPresent()) {
			vendorRepo.deleteById(vendorId);
			return ResponseEntity.ok(op.get());// 200
		} else {
			return ResponseEntity.badRequest().build();// 401
		}
	}

	@PutMapping("vendor")
	public ResponseEntity<?> modifyVendor(@RequestBody VendorBean vendor) {
		vendorRepo.save(vendor);// insert - update -> data input -> id
		return ResponseEntity.ok(vendor);
	}

}
