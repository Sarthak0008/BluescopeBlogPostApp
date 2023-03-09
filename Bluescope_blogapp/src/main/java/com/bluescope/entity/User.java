package com.bluescope.entity;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    
	    @NotBlank
	    @NotEmpty
	    @NotNull
	    private String name;
	    
	    @NotBlank
	    @NotEmpty
	    @NotNull
	    private String email;
	    
	   
	    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include alphanumerics and special characters")
	    private String password;
	    
	    @Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	    private String mobile;
	    
	    @JsonIgnore
		@OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "blogpost")
		private List<Post> blogpost = new ArrayList<>();

}
