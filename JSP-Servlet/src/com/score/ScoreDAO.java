package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//�� Ŭ������ Table�� ���� ������ �˰� �־���� / DB�� ��ġ ������ ���� �־����
//ScoreDAO�� ��ü������ �� �� DB�� ��ġ ������ �����־����.

public class ScoreDAO {
	
	//������������ ������ ���� �̶� ��.
	//conn�� ���� ���� ������ֱ� ������Ÿ���� Connection�̴�.
	private Connection conn;
	
	public ScoreDAO(Connection conn) {
		this.conn = conn;
	}
	
	//�Է� - JDBC
	public int inserData(ScoreDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into score(hak,name,kor,eng,mat) ";
			sql += "values (?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getHak());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result; // 0�ƴϸ� 1 ���� ȣ���ؿ�
	}
	
	
	//��ü ������
	public List<ScoreDTO> getLists() {
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select hak,name,kor,eng,mat,";
			sql+= "(kor+eng+mat) tot, (kor+eng+mat)/3 ave,";
			sql+= "rank() over (order by (kor+eng+mat) desc) rank ";
			sql+= "from score";
			
			pstmt = conn.prepareStatement(sql);
			
			//������ ����� rs�� �޴´�
 			rs = pstmt.executeQuery();
 			
 			//�����Ͱ� ����� �𸣴� while��
 			while(rs.next()) {
 				
 				ScoreDTO dto = new ScoreDTO();
 				
 				dto.setHak(rs.getString("hak"));
 				dto.setName(rs.getString("name"));
 				dto.setKor(rs.getInt("kor"));
 				dto.setEng(rs.getInt("eng"));
 				dto.setMat(rs.getInt("mat"));
 				dto.setTot(rs.getInt("tot"));
 				dto.setAve(rs.getInt("ave"));
 				dto.setRank(rs.getInt("rank"));
 				
 				lists.add(dto);
 			}
 			
 			pstmt.close();
 			rs.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
		
	}
	
	
	//������ ������ ��������(�й����� �˻�)
	public ScoreDTO getReadData(String hak) {
		
		ScoreDTO dto = null; //�����Ͱ� �������������� ��ü���� ���� ���ϰ� null��
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select hak,name,kor,eng,mat from score ";
			sql+= "where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, hak);
			
			//�����ϸ� rs�� �޴´�
			rs = pstmt.executeQuery();
			
			//�����Ͱ� 1�������ų� �ȳ��´� �׷��� if ����
			if(rs.next()) {
				
				dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
			}
			
			rs.close();
			pstmt.close();
					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto; 
	}
	
	//���� - (������ �Է°� ���� �����ϴ�.)
		public int updateData(ScoreDTO dto) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				
				sql = "update score set kor=?, eng=?, mat=? where hak=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getKor());
				pstmt.setInt(2, dto.getEng());
				pstmt.setInt(3, dto.getMat());
				pstmt.setString(4, dto.getHak());
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return result; // 0�ƴϸ� 1 ���� ȣ���ؿ�
		}
		
		
		//����
		public int deleteData(String hak) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				
				sql = "delete score where hak=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, hak);
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return result;
		}
	
	

}
