package website.treelink.global.security;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
	public int selectUrlIsAllowed(RoleVO.UrlAccessCheck userNoUrl);
}
