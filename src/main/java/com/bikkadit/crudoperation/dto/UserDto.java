package com.bikkadit.crudoperation.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long userId;
	
	private String userName;
	
	private String userNumber;
	
	private String userEmail;
}
