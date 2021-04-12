package out.stagarm.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class UserRegistrationModel {
	
	@NotEmpty(message = "ID를 입력하세요")
	String userid;
	
	@NotEmpty(message = "비밀번호를 입력하세요")
	String passwd1;
	
	@NotEmpty(message = "이름을 입력하세요")
	String name;
	
	String phone;
}
