package com.score6;
import java.sql.CallableStatement;
//�� ���ν��� -���ν����� ȸ�翡�� ���ν����� �ϸ� �ϰ� �츮�� statement�� �ҰŴ�
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

import oracle.jdbc.OracleTypes; //����Ŭ Ÿ�� import

//����� DB�� �����ؼ� query(����)�� �����ϴ� ��

public class ScoreDAO { // Data Access Object
	
	//�Է� - DTO�� �����͸� ���� �Ű����� �غ�
	public int insertData(ScoreDTO dto) {
		
		int result = 0; //result�� DB�� �� ����Ǹ� 1�� �ȵǸ� 0���� ��ȯ�Ѵ�.
		
		//DB����
		Connection conn = DBConn.getConnection();
		
		//���ν����� ȣ���ؼ� �����Ű�� statement
		CallableStatement cstmt = null;
		String sql;
		
		try {
			
			
			//���ν��� ȣ�� ��� : �߰�ȣ { }
			sql = "{call insertScore(?,?,?,?,?)}"; 
			
			
			cstmt = conn.prepareCall(sql);
			
			//������ �־��ֱ�
			cstmt.setString(1, dto.getHak());//�̸��̴�String / �̸��� ù��° ? �� 1 / ����ֳ�? getHak�� �ִ�.
			cstmt.setString(2, dto.getName());
			cstmt.setInt(3, dto.getKor());
			cstmt.setInt(4, dto.getEng());
			cstmt.setInt(5, dto.getMat());
			
			//�Ϻ��� sql ����
			result = cstmt.executeUpdate(); //�� ����Ǹ� 1, �ƴϸ� 0�� ��ȯ
			
			cstmt.close(); //�ٛ����� DB�ݾ��ֱ�
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		return result; //result ��ȯ
	}
	
	
	//������ ����(update)
	public int updateDate(ScoreDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;//�������̽��� Ŭ������. Ŭ������ �ʱⰪ�� null�̴�.
		
		String sql;
		
		try {
			
			sql = "{call updateScore(?,?,?,?)}";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, dto.getHak());
			cstmt.setInt(2, dto.getKor());
			cstmt.setInt(3, dto.getEng());
			cstmt.setInt(4, dto.getMat());
			
			
			//����
			result = cstmt.executeUpdate(); // 0�ƴϸ� 1 ���� ����
			
			cstmt.close(); // �ݾ��ְ�
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
		
	}
	
	//����(delete)
	public int deleteData(String hak) { //�����Ҷ� �й��� ������Ǵ� ScoreDTO��� String hak
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		
		String sql;
		
		try {
			
			sql = "{call deleteScore(?)}";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, hak); // hak���� ������ hak����
			
			result = cstmt.executeUpdate();
			
			cstmt.close(); //�ݱ�
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	//��ü ���
	//--��ü����� �ٲܰ��� ����
	public List<ScoreDTO> getList() {
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			//select�� �����Ͱ� (?) ������ ����.
			sql = "{call selectAllScore(?)}";
			
			cstmt = conn.prepareCall(sql);
			
			//out �Ķ������ �ڷ����� ���� (?)�� ����Ŭ���� ó��������Ѵ�. ?�� ������Ÿ���� Ŀ�� Ÿ��
			cstmt.registerOutParameter(1, OracleTypes.CURSOR); //����Ŭ Ÿ���� �ȳ���.why? ���̼��� ����������
			//�׷��� �ܺζ��̺귯�� ����� ����� �Ѵ�.
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� ���� �ޱ� - ����Ŭ���� �����ϱ� object�ιޱ�
			rs = (ResultSet)cstmt.getObject(1); //object�� �޾����� down-casting
			
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
			cstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists; //��ȯ���� DTO�� ����ִ� lists�� ��ȯ
		
	}
	
	//�̸� �˻� - ���� ���ν��� �����ϱ� �̸�@@@@@@@@@@@@@@@@@@2
	public List<ScoreDTO> getList(String name) { //�����ε�
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			
			sql = "{call selectNameScore(?,?)}"; //���� ���� 2�� �޴°�, ����ִ� ��
			
			cstmt = conn.prepareCall(sql);
			
			
			
			//out �Ķ���� �ڷ��� ����
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in �Ķ����
			cstmt.setString(2, name);
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ���� �� �ޱ�
			rs = (ResultSet)cstmt.getObject(1);
			
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
			cstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists; //��ȯ���� DTO�� ����ִ� lists�� ��ȯ

	}
	
	//�й� �˻�
	//--�й� �˻��� ������ ������ ������ �ȳ��´�.
		public ScoreDTO getHakList(String hak) {
			
			//���⼭�� list�� �ʿ��� ScoreDTO�Ѵ�. �׸��� ScoreDTO�� ��ü������ �ʿ䰡 ��� null��
			ScoreDTO dto = null;
			Connection conn = DBConn.getConnection();
			CallableStatement cstmt = null;
			ResultSet rs = null;
			
			String sql;
			
			try {
				
				sql = "{call selectHakScore(?,?)}";
				
				cstmt = conn.prepareCall(sql);
				
				//out �Ķ���� �ڷ��� ����
				cstmt.registerOutParameter(1, OracleTypes.CURSOR);
				
				//in �Ķ����
				cstmt.setString(2, hak);
				
				//���ν��� ����
				cstmt.executeUpdate();
				
				//out �Ķ���� �� �ޱ�
				rs = (ResultSet)cstmt.getObject(1);
				
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
				cstmt.close();
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return dto; //��ȯ���� dto

		}
}