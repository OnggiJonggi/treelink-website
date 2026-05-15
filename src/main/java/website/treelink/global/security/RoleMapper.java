package website.treelink.global.security;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
	public int selectUrlIsAllowed(RoleVO.UrlAccessCheck userNoUrl);

	public List<String> selectMemberRole(int number);
}
