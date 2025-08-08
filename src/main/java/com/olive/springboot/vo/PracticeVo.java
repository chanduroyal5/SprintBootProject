package com.olive.springboot.vo;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PracticeVo {

	@Pattern(regexp = "^\\d+$", message = "Only numbers are allowed in Id")
	private String id;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabetic characters are allowed in name")
	private String name;

	
}
