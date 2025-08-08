package com.olive.springboot.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.olive.springboot.vo.PracticeVo;

import jakarta.validation.Valid;

@RestController
@Validated
public class PracticeController {

	@PostMapping("/post")
	public DeferredResult<String> getDetails(@RequestBody @Valid PracticeVo vo, BindingResult bindingResult) {
		DeferredResult<String> dr = new DeferredResult<>();
		if(bindingResult.hasErrors()){
			dr.setResult(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		
		dr.setResult("Values accepted.....");
		return dr;
	}
}
