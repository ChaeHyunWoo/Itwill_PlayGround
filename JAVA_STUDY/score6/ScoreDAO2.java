package com.score6;
//preparedStatement
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

//����� DB�� �����ؼ� query(����)�� �����ϴ� ��

public class ScoreDAO2 { // Data Access Object
	
	//�Է� - DTO�� �����͸� ���� �Ű����� �غ�
	public int insertData(ScoreDTO dto) {
		
		int result = 0; //result�� DB�� �� ����Ǹ� 1�� �ȵǸ� 0���� ��ȯ�Ѵ�.
		
		//DB����
		Connection conn = DBConn.getConnection();
		
		//DB���� ���� ������ �������ִ¾ְ� statement�ε� �츰 prepared�� ��
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			/*
			//�̰� Statement ����̴�.�����ϴ�. �׷��� �츰 PreparedStatement����� �� -�����常 ���
			//���� ��������� �޾ƾ��ϴ� ���⼭ ��� ���߰�Score������ ������ش�.
			sql = "insert into score (hak,name,kor,eng,mat) ";
			sql+= "values ('" + dto.getHak() + "','"; // �й��� DTO�� ���ִ�.
			sql+= dto.getName() + ",'";
			sql+= dto.getKor() + ",";
			sql+= dto.getMat() + ",";
			sql+= dto.getEng() + ")";
			*/
			
			//PreparedStatement���
			sql = "insert into score (hak,name,kor,eng,mat) ";
			sql+= "values (?,?,?,?,?)"; //�Է��� �����Ͱ� 5���� ?�� 5�� ����ָ� �ȴ�.
			
			//statement connection�� ����
			//pre�� �̸� �غ��ؼ� �̸� sql�� �������� �˻縦 �޴´�. �׳� statement�� �߰����� �������� �˻���
			pstmt = conn.prepareStatement(sql);//�����Ͱ� �̻��� ������ pstmt�� �ִ´�.
			
			//������ �־��ֱ�
			pstmt.setString(1, dto.getHak());//�̸��̴�String / �̸��� ù��° ? �� 1 / ����ֳ�? getHak�� �ִ�.
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			//�Ϻ��� sql ����
			result = pstmt.executeUpdate(); //�� ����Ǹ� 1, �ƴϸ� 0�� ��ȯ
			
			pstmt.close(); //�ٛ����� DB�ݾ��ֱ�
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		return result; //result ��ȯ
	}
	
	
	//������ ����(update)
	public int updateDate(ScoreDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;//�������̽��� Ŭ������. Ŭ������ �ʱⰪ�� null�̴�.
		
		String sql;
		
		try {
			
			sql = "update score set kor=?,eng=?,mat=? where hak=?"; //�����͸� ?�� ǥ���ϴ°� preparedstatement�̴�.
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setString(4, dto.getHak());
			
			//����
			result = pstmt.executeUpdate(); // 0�ƴϸ� 1 ���� ����
			
			pstmt.close(); // �ݾ��ְ�
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
		
	}
	
	//����(delete)
	public int deleteData(String hak) { //�����Ҷ� �й��� ������Ǵ� ScoreDTO��� String hak
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
		String sql;
		
		try {
			
			sql = "delete score where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, hak); // hak���� ������ hak����
			
			result = pstmt.executeUpdate();
			
			pstmt.close(); //�ݱ�
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	//��ü ���
	// - DB���� select�ؼ� DAO�� �ְ� score�� �Ѱ��ְ� score���� �����͸� ����Ѵ�.
	public List<ScoreDTO> getList() {
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			
			sql = "select hak,name,kor,eng,mat, ";
			sql+= "(kor+eng+mat) tot,(kor+eng+mat)/3 ave, ";
			sql+= "rank() over (order by (kor+eng+mat) desc) rank ";
			sql+= "from score";
			
			pstmt = conn.prepareStatement(sql);
			
			// ���� ?�� ��� ���ุ �ϸ� �ȴ�
			
			//����� ����� rs�� �޴´�
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ScoreDTO dto = new ScoreDTO(); //�������� ������ŭ ���������ϱ⶧���� while�� �ȿ� ����
				
				dto.setHak(rs.getString("hak")); //rs�� �ִ� String������ hak�� �����´�.
				dto.setName(rs.getString(2)); // 2 �� name�̴�. ��ȣ�� ������ ���⼭�� ������ ȸ�翡�� ��ȣ�� ���� �Ⱦ���.
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
				dto.setRank(rs.getInt("rank"));
				
				lists.add(dto); //���� �����͵��� lists�� �־��ش�.
				
			}
			
			rs.close(); //�ݺ��� ������ �ݾ��ְ�
			pstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists; //��ȯ���� DTO�� ����ִ� lists�� ��ȯ
		
	}
	
	//�̸� �˻�
	public List<ScoreDTO> getList(String name) { //�����ε�
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			
			sql = "select hak,name,kor,eng,mat,";
			sql+= "(kor+eng+mat) tot,(kor+eng+mat)/3 ave ";
			sql+= "from score where name like ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name + "%");
			
			// ���� ?�� ��� ���ุ �ϸ� �ȴ�
			
			//����� ����� rs�� �޴´�
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ScoreDTO dto = new ScoreDTO(); //�������� ������ŭ ���������ϱ⶧���� while�� �ȿ� ����
				
				dto.setHak(rs.getString("hak")); //rs�� �ִ� String������ hak�� �����´�.
				dto.setName(rs.getString(2)); // 2 �� name�̴�. ��ȣ�� ������ ���⼭�� ������ ȸ�翡�� ��ȣ�� ���� �Ⱦ���.
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
				
				lists.add(dto); //���� �����͵��� lists�� �־��ش�.
				
			}
			
			rs.close(); //�ݺ��� ������ �ݾ��ְ�
			pstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists; //��ȯ���� DTO�� ����ִ� lists�� ��ȯ

	}
	
	//�й� �˻�
	//--�й� �˻��� ������ ������ ������ �ȳ��´�.
		public ScoreDTO getHakList(String hak) {
			
			//�й��� �⺻Ű�� ������(���ڵ�)�� 1���� list�� �� �ʿ䰡 ����.
			// ���⼭�� ��ü ������ �ʿ���°� �����Ͱ� ������ ��ü�� �����ؼ� ������ �ǰ�,
			//������ ��ü�� ������ �ʿ䰡 ��� null�� ���� �س�����.
			ScoreDTO dto = null;
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql;
			
			try {
				
				sql = "select hak,name,kor,eng,mat,";
				sql+= "(kor+eng+mat) tot,(kor+eng+mat)/3 ave ";
				sql+= "from score where hak=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, hak);
				
				// ���� ?�� ��� ���ุ �ϸ� �ȴ�
				
				//����� ����� rs�� �޴´�
				rs = pstmt.executeQuery();
				
				if(rs.next()) { //rs�� �����Ͱ� ������ ����ض�
					
					dto = new ScoreDTO(); //�������� ������ŭ ���������ϱ⶧���� while�� �ȿ� ����
					
					dto.setHak(rs.getString("hak")); //rs�� �ִ� String������ hak�� �����´�.
					dto.setName(rs.getString(2)); // 2 �� name�̴�. ��ȣ�� ������ ���⼭�� ������ ȸ�翡�� ��ȣ�� ���� �Ⱦ���.
					dto.setKor(rs.getInt("kor"));
					dto.setEng(rs.getInt("eng"));
					dto.setMat(rs.getInt("mat"));
					dto.setTot(rs.getInt("tot"));
					dto.setAve(rs.getInt("ave"));
					
				}
				
				rs.close(); //�ݺ��� ������ �ݾ��ְ�
				pstmt.close();
				
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return dto; //��ȯ���� dto

		}
}