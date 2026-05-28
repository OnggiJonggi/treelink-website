package com.tl.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tl.global.exception.CustomException;
import com.tl.global.exception.ErrorCodeEnum;

import lombok.RequiredArgsConstructor;

/**
 * 회원 계정 관리 클라쓰
 * 로그인/로그아웃은 MemberSecurityService가서 찾아라
 */
@Service
@RequiredArgsConstructor
public class MemberService{
	private final MemberDao memberDao;
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 회원 가입
	 */
	@Transactional
	public void join(MemberVO.Join memberJoin) {
		// 아이디 중복 검사
		if(memberDao.selectCheckId(memberJoin.getUserId()) > 0 )
			throw new CustomException(ErrorCodeEnum.ID_IS_DUPLICATED);
		
		// 닉네임 중복 검사
		if(memberDao.selectCheckNickname(memberJoin.getNickname()) > 0)
			throw new CustomException(ErrorCodeEnum.NICKNAME_IS_DUPLICATED);
		
		// 비번 암호화
		memberJoin.setUserPwd(passwordEncoder.encode(memberJoin.getUserPwd()));
		
		// DB에 추가하기
		if(memberDao.insertJoin(memberJoin) ==0)
			throw new CustomException(ErrorCodeEnum.CANNOT_CREATE_MEMBER);

		return;
	}

	/**
	 * 아이디 중복확인
	 */
	public void checkId(String userId) {
		if(memberDao.selectCheckId(userId) > 0)
			throw new CustomException(ErrorCodeEnum.ID_IS_DUPLICATED);
	}
	
	/**
	 * 닉네임 중복 확인
	 */
	public void checkNick(String nickname) {
		if(memberDao.selectCheckNickname(nickname) > 0)
			throw new CustomException(ErrorCodeEnum.NICKNAME_IS_DUPLICATED);
	}
}
