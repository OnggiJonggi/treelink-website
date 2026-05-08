package website.treelink.member;

public interface MemberAccountService {

	public void join(MemberVO.Join memberJoin);

	public void checkId(String userId);

	public void checkNick(String nickname);
	
}
