package com.imageTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImageTestDAO {

	private Connection conn = null;

	public ImageTestDAO(Connection conn) {

		this.conn = conn;
	}

	// ���ڵ� ��ȣ
	public int getMaxNum() {

		int maxNum = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select nvl(max(num),0) from imageTest";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				maxNum = rs.getInt(1);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return maxNum;

	}

	// ���� ������ �� ��
	public void insertData(ImageTestDTO dto) {

		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into imageTest (num,subject,saveFileName) ";
			sql += "values (?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getSaveFileName());

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	// ���ϵ����� ��ü��ȸ
	public List<ImageTestDTO> getList(int start, int end) {

		List<ImageTestDTO> lists = new ArrayList<ImageTestDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select * from (select rownum rnum,num,subject,saveFileName ";
			sql += "from imageTest order by num desc) ";
			sql += "where rnum >= ? and rnum <=? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ImageTestDTO dto = new ImageTestDTO();
				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setSaveFileName(rs.getString("saveFileName"));
				lists.add(dto);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}

	// Ư�� ������ ��ȸ
	public ImageTestDTO getReadData(int num) {

		ImageTestDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select num,subject,saveFileName from imageTest where num = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num); // �Ű������� ���� num. where���ǿ� �־���
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new ImageTestDTO();
				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setSaveFileName(rs.getString("saveFileName"));
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;

	}

	// ���ϵ����� ����
	public void deleteData(int num) {

		PreparedStatement pstmt = null;
		String sql;
		try {
			sql = "delete imageTest where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// ������ ����
	public int getDataCount() {

		int totalDataCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select nvl(count(*),0) from imageTest ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				totalDataCount = rs.getInt(1);

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return totalDataCount;
	}

}