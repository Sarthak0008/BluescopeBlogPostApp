package com.bluescope.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@NotBlank
	@NotEmpty
	@NotNull
    private String title;
    
	@NotBlank
	@NotEmpty
	@NotNull
    private String content;
    
	@NotBlank
	@NotEmpty
	@NotNull
    private String author;
    
	@NotBlank
	@NotEmpty
	@NotNull
    private LocalDate date;
	
	 @JsonIgnore
	 @ManyToOne(cascade =  CascadeType.ALL)
	 @JoinColumn(name = "user_userId")
	 private User user;

}
