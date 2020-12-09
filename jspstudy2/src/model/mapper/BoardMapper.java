package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Board;

public interface BoardMapper {

	@Select("select ifnull(max(num),0) from board")
	int maxnum();
	
	@Insert("insert into board (num, name, pass, subject, content, file1, regdate, readcnt, grp, grplevel, grpstep) "
			+ "values(#{num},#{name},#{pass},#{subject},#{content},#{file1},now(),0,#{grp},#{grplevel},#{grpstep})")
	void insert(Board board);
	
	@Select({"<script>",
			 "select count(*) from board ",
			 "<if test='col1!=null'> where ${col1} like '%${find}%'</if>",
			 "<if test='col2!=null'> or ${col2} like '%${find}%'</if>",
			 "<if test='col3!=null'> or ${col3} like '%${find}%'</if>",
			 "</script>"})
	int boardCount(Map<String, Object> map);
	
	@Select({"<script>"
			+ "select * from board"
			+ "<if test='col1!=null'> where ${col1} like '%${find}%'</if>"
			+ "<if test='col2!=null'> or ${col2} like '%${find}%'</if>"
			+ "<if test='col3!=null'> or ${col3} like '%${find}%'</if>"
			+ "<if test='num != null'>where num=#{num}</if>"
			+ "<if test='start != null'>"
			+ "order by grp desc, grpstep asc limit #{start},#{limit}</if>"
			+ "</script>"})
	List<Board> select(Map<String, Object> map);

	@Update("update board set readcnt= readcnt+1 where num=#{num}")
	void readcntAdd(int num);
	
/*	@Update("update board set grpstep = grpstep+1 where grp = #{grp} and grpstep > #{grpstep}")
	void grpStepAdd(Map<String, Object> map);*/
	
	@Update("update board set name=#{name}, subject=#{subject}, content=#{content}, file1=#{file1} where num=#{num}")
	void update(Board board);

	@Delete("delete from board where num=#{num}")
	int delete(int num);

	void grpStepAdd
	(@Param("grp")int grp,@Param("grpstep") int grpstep);
	
}
