package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	public int insert(Member mem) {
		//연결객체 생성
		Connection conn=DbConnection.getConnection();
		//문장을 준비하는 객체
		PreparedStatement pstmt=null;
		String sql="insert into member (id,pass,name,gender,email,tel,picture) values(?,?,?,?,?,?,?)";
		try {
			//sql구문을  dbms에 전달. 파라미터 전송이 가능
			pstmt=conn.prepareStatement(sql);
			//1: 첫번째 ? 의 값 설정
			pstmt.setString(1,mem.getId());
			pstmt.setString(2,mem.getPass());
			pstmt.setString(3,mem.getName());
			pstmt.setInt(4,mem.getGender());
			pstmt.setString(5,mem.getEmail());
			pstmt.setString(6,mem.getTel());
			pstmt.setString(7,mem.getPicture());
			//int executeUpdate(): select구문을 제외한 sql구문 실행시 사용. 레코드가 변경된 갯수 리턴
			return pstmt.executeUpdate();//1리턴
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.close(conn,pstmt,null);
		}
		return 0;
	}
	//id: 화면에서 입력된 id값
	public Member selectOne(String id) {
		Connection conn=DbConnection.getConnection();
		String sql="select * from member where id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id); //db에 전달할 파라미터(?)값 설정
			rs=pstmt.executeQuery();
			if(rs.next()){ //id에 해당하는 Member정보가 존재.
				Member mem=new Member();
				mem.setId(rs.getString("id"));
				mem.setPass(rs.getString("pass"));
				mem.setName(rs.getString("name"));
				mem.setGender(rs.getInt("gender"));
				mem.setTel(rs.getString("tel"));
				mem.setEmail(rs.getString("email"));
				mem.setPicture(rs.getString("picture"));
				return mem;//id에 해당하는 db의 정보 저장
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.close(conn, pstmt, rs);
		}
		return null;
       }
	//m: 화면에 입력된 정보 저장하고 있는 객체 
		public int update(Member m) {
			Connection conn = DbConnection.getConnection();
			PreparedStatement pstmt=null;
			String sql="update member set name=? ,gender=?, email=?, tel=?, picture=? where id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, m.getName());
				pstmt.setInt(2, m.getGender());
				pstmt.setString(3, m.getEmail());
				pstmt.setString(4, m.getTel());
				pstmt.setString(5, m.getPicture());
				pstmt.setString(6, m.getId());
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.close(conn, pstmt, null);
			}
			return 0;
		}
		public List<Member> list(){
			Connection conn=DbConnection.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<Member> list=new ArrayList<Member>();
			try {
				pstmt=conn.prepareStatement("select * from member");
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Member m=new Member();
					m.setId(rs.getString("id"));
					m.setPass(rs.getString("pass"));
					m.setName(rs.getString("name"));
					m.setGender(rs.getInt("gender"));
					m.setTel(rs.getString("tel"));
					m.setEmail(rs.getString("email"));
					m.setPicture(rs.getString("picture"));
					list.add(m);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.close(conn, pstmt, rs);
			}
			return null;
		}
	public int delete(String id) {
		Connection conn=DbConnection.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete from member where id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.close(conn, pstmt, null);
		}
		return 0;
	}
	public int updatePass(String id, String pass) {
	      Connection conn = DbConnection.getConnection();
	      String sql = "update member set pass = ? where id = ?";
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, pass);
	         pstmt.setString(2, id);
	         return pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DbConnection.close(conn, pstmt, rs);
	      }
	      return 0;
	   }
	public String idSearch(String email, String tel) {
		Connection conn = DbConnection.getConnection();
	      String sql = "select id from member where email = ? and tel = ?";
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, email);
	         pstmt.setString(2, tel);
	         rs= pstmt.executeQuery();
	         if(rs.next()) {
	        	 return rs.getString("id");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DbConnection.close(conn, pstmt, rs);
	      }
	      return null;
	}
	public String pwSearch(String id, String email, String tel) {
		Connection conn = DbConnection.getConnection();
	      String sql = "select pass from member where id = ? and email = ? and tel = ?";
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         pstmt.setString(2, email);
	         pstmt.setString(3, tel);
	         rs= pstmt.executeQuery();
	         if(rs.next()) {
	        	 return rs.getString("pass");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DbConnection.close(conn, pstmt, rs);
	      }
	      return null;
	}
}
