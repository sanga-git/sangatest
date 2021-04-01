package com.victolee.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.victolee.board.domain.Role;
import com.victolee.board.domain.entity.MemberEntity;
import com.victolee.board.domain.repository.MemberRepository;
import com.victolee.board.dto.MemberDto;



import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService{
	
	
	private MemberRepository memberRepository;
	@Transactional
	public Long joinUser(MemberDto memberDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getId();
	}
	
	
	//loadUserByUsername : 상세정보를 조회하는 메소드이며 ,사용자의 계정정보와 권한을 갖는 UserDetils인터페이스를 반환해야한다.
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(userEmail);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
	}
	
	

}
