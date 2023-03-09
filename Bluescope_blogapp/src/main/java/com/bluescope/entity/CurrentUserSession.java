package com.bluescope.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CurrentUserSession {

	
	@Id
	private Integer id;
	private String email;
	private LocalDate localDate=LocalDate.now();
	private String UUID;
}
