package website.treelink.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberDao {
	private final SqlSessionTemplate sqlSession;

	public MemberVO.Detail selectMemberById(String userId) {
		return sqlSession.selectOne("MemberMapper.selectMemberById", userId);
	}
	
	public int selectCheckId(String userId) {
		return sqlSession.selectOne("MemberMapper.selectCheckId", userId);
	}
	
	public int insertJoin(MemberVO.Join memberJoin) {
		return sqlSession.insert("MemberMapper.insertJoin", memberJoin);
	}

	public int selectCheckNickname(String nickname) {
		return sqlSession.selectOne("MemberMapper.selectCheckNickname", nickname);
	}

	
}
