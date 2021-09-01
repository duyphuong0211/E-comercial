package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

@Getter
@Setter
public class UserCreateForm {

	@NotEmpty
	@Length(min = 2, max = 50)
	private String name = "";

	@NotEmpty
	@Length(min = 6, max = 36)
	private String username = "";

	@NotEmpty
	@Length(min = 2, max = 40)
	@Email
	private String email = "";

	@NotEmpty
	@Min(6)
	private String password = "";

	@NotEmpty
	private String passwordConfirm = "";

}
