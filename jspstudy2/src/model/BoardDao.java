package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.mapper.BoardMapper;

public class BoardDao {
	private Class<BoardMapper> cls=BoardMapper.class;
	private Map<String, Object> map=new HashMap<>();
	public int maxnum() {
		SqlSession session=MyBatisConnection.getConnection();
		try {
			return session.getMapper(cls).maxnum();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
		return 0;
	}
	
	public boolean insert(Board board) {
		SqlSession session=MyBatisConnection.getConnection();
		try {
			session.getMapper(cls).insert(board);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
		return false;
	}
	
	public int boardCount() {
		SqlSession session=MyBatisConnection.getConnection();
		try {
				return session.getMapper(cls).boardCount();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
		return 0;
	}
	
	public List<Board> list(int pageNum, int limit){
		SqlSession session=MyBatisConnection.getConnection();
		String sql="";
		try {
			map.clear();
			map.put("start", (pageNum-1) * limit);
			map.put("limit", limit);
			
			return session.getMapper(cls).select(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
		return null;
	}
	public Board selectOne(int num) {
		SqlSession session=MyBatisConnection.getConnection();
		try {
			map.clear();
			map.put("num", num);
			return session.getMapper(cls).select(map).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
		return null;
       }
	public void readcntAdd(int num) {
		SqlSession session=MyBatisConnection.getConnection();
		try {
			session.getMapper(cls).readcntAdd(num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
	}
	public void grpStepAdd(int grp, int grpstep) {
		SqlSession session=MyBatisConnection.getConnection();
		try {
			map.clear();
			map.put("grp", grp);
			map.put("grpstep", grpstep);
			session.getMapper(cls).grpStepAdd(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
	}
	public boolean update(Board board) {
		SqlSession session=MyBatisConnection.getConnection();
		try {
			session.getMapper(cls).update(board);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
		return false;
	}
	public boolean delete(int num) {
		SqlSession session=MyBatisConnection.getConnection();
		try {
			session.getMapper(cls).delete(num);
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisConnection.close(session);
		}
		return false;
	}
}
