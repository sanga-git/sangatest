package out.stagarm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@org.hibernate.annotations.DynamicUpdate // 나중에 필요해서 미리 설정 / 수정가능하게 해줌
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increase
	int id;
	
	
	String userId;
	String password;
	String name;
	String introduce;
	String phone;
	String website;
	String userType;
	int enable;

}
