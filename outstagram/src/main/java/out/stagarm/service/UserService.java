package out.stagarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import out.stagarm.domain.User;
import out.stagarm.model.UserRegistrationModel;
import out.stagarm.repository.UserRepository;
import out.stagarm.utils.EncryptionUtils;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	//참조형 매개변수 user를 사용해 
	public User login(String userId,String password) {
		User user=userRepository.findOneByUserId(userId);
		
		if(user==null)
			return null;
		
		String pw=EncryptionUtils.encryptMD5(password); //비밀번호 찾았으면 암호화해서 
		
		if(user.getPassword().equals(pw)==false)//비밀번호가 서로다르면
			return null;
		
		return user;
	}
	
	

	
	public User findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
	
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	//회원가입할때 중복여부 체크하기 
	//BindingResult 검증할 객체뒤에 입력해주어야한다. 
	
	public boolean hasErrors(UserRegistrationModel userModel,BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors())
			return true;
		
		User user =userRepository.findOneByUserId(userModel.getUserid());//유저를 찾음 
		if(user!= null) {
			bindingResult.rejectValue("userid", null,"사용자 아이디가 중복됩니다.");
			return true;//에러 true(존재)
		}
		return false;
	}
	
	//새로 가입하는거 
	public User createEntity(UserRegistrationModel userModel) { //유저 객체에서 유저를 받아온다.
		User user=new User(); //새로운 유저생성
		String pw=EncryptionUtils.encryptMD5(userModel.getPasswd1());//비번은암호화해서저장
		user.setUserId(userModel.getUserid());
		user.setPassword(pw);
		user.setName(userModel.getName());
		user.setPhone(userModel.getPhone());
		
		user.setEnable(1);
		user.setUserType("user");//유저로 가입
		
		return user;
		

	}
	
	//save로 유저 저장 
	public void save(UserRegistrationModel userModel) {
		User user= createEntity(userModel);//유저 모델객체를 보내서 유저생성
		userRepository.save(user);
				
	}


	

}
