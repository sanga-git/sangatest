package out.stagarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import out.stagarm.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	//jpa를 사용해서 db의 데이터를 가져옴
	
	User findOneByUserId(String userId); //user id로 user를 찾음
	
	
	User findById(int id); //
	User findByUserId(String userId);


	

}
