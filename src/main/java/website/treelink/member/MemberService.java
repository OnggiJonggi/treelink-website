package website.treelink.member;

public interface MemberService {

	public void join(MemberVO.Join memberJoin);

	public void checkId(String userId);

	public void checkNick(String nickname);
	
}
