package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.ksmart.dto.Member;

public class Mdao {
	//default ������ �޼��� ����
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Member m;
	ArrayList<Member> alm;
	
	public Mdao() {
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init DAO() ");
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  	    
		}catch(Exception ex){
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}

	// 01 �Է� ó�� 
	
	public void mInsert(Member m) throws SQLException {
		System.out.println("mInsert �޼��� Mdao.java");
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("INSERT INTO oracle_member VALUES (?, ?, ?, ?, ?)");
		pstmt.setString(1, m.getOra_id());
		pstmt.setString(2, m.getOra_pw());
		pstmt.setString(3, m.getOra_level());
		pstmt.setString(4, m.getOra_name());
		pstmt.setString(5, m.getOra_email());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	
	public ArrayList<Member> mAllSelect() throws SQLException {
		System.out.println("mAllSelect �޼��� Mdao.java");
		
		alm = new ArrayList<Member>();
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT * FROM oracle_member");
		rs = pstmt.executeQuery();
		while(rs.next()) {
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			alm.add(m);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return alm;

	}
	
	public Member mUpdateSelect(String mid) throws SQLException {
		System.out.println("mUpdateSelect �޼��� Mdao.java");
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT * FROM oracle_member WHERE ora_id=?");
		pstmt.setString(1, mid);
		rs = pstmt.executeQuery();
		Member m = new Member();
		
		while(rs.next()) {
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return m;
	}
	
	public void mUpdate(Member m) throws SQLException {
		System.out.println("mUpdate �޼��� Mdao.java");
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("Update oracle_member SET ora_pw=?, ora_level=?, ora_name=?, ora_email=? WHERE ora_id=?");
		pstmt.setString(1, m.getOra_pw());
		pstmt.setString(2, m.getOra_level());
		pstmt.setString(3, m.getOra_name());
		pstmt.setString(4, m.getOra_email());
		pstmt.setString(5, m.getOra_id());
		
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
		
	}
	
	public void mDelete(String id) throws SQLException {
		System.out.println("mDelete �޼��� Mdao.java");
		System.out.println(id + "<-- input ID �� mDelete �޼��� Mdao.java");
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM oracle_member WHERE ora_id=?");
		pstmt.setString(1, id);
		
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	

	public ArrayList<Member> mSearch(String key, String word) throws SQLException {
		System.out.println("mSearch �޼��� Mdao.java");
		System.out.println(key + "<--- input key �� mSearch �޼��� Mdao.java");
		System.out.println(word + "<--- input word �� mSearch �޼��� Mdao.java");
		alm = new ArrayList<Member>();
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT * FROM oracle_member WHERE " + key + "=?");
		pstmt.setString(1, word);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			alm.add(m);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return alm;
	}
	
	
	public Member mLogin(String id, String pw) throws SQLException {
		System.out.println("mLogin �޼��� Mdao.java");
		System.out.println(id + "<--- input id �� mLogin �޼��� Mdao.java");
		System.out.println(pw + "<--- input pw �� mLogin �޼��� Mdao.java");
		
		Member m = new Member();
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT ora_id, ora_level, ora_name FROM oracle_member WHERE ora_id=? AND ora_pw=?");
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return m;
	}
	

}
