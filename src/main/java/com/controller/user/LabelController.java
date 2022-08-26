package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LabelBean;
import com.repository.LabelRepository;
import com.repository.LableDetailRepository;

@RestController
@RequestMapping("/user")
public class LabelController {

	@Autowired
	LabelRepository labelRepo;

	@Autowired
	LableDetailRepository labelDetailRepo;

	@PostMapping("/label")
	public ResponseEntity<?> addLable(@RequestBody LabelBean label) {

//		labelRepo.save(label);
//		System.out.println(label.getLable());
//		System.out.println(label.getLabelDetail().getDescription());
// 		labelRepo.save(label);
		labelDetailRepo.save(label.getLabelDetail());//detail
		
		labelRepo.save(label);//label 

		label.getLabelDetail().setLabel(label);
		
		labelDetailRepo.save(label.getLabelDetail());//detail
		
		return ResponseEntity.ok(label);
	}

}
