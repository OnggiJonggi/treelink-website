package website.treelink.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

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
