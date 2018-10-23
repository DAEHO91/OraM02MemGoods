package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.ksmart.dto.Goods;

public class Gdao {
	
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Goods g;
	ArrayList<Goods> alm;
	
	
	public Gdao() {
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init DAO() ");
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  	    
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//리스트 조회
	public ArrayList<Goods> gAllSelect() throws SQLException {
		System.out.println("gAllSelect 메서드 Gdao.java");
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT * FROM ksmart_goods");
		rs = pstmt.executeQuery();
		alm = new ArrayList<Goods>();
		
		while(rs.next()) {
			g = new Goods();
			g.setG_code(rs.getString("g_code"));
			g.setG_name(rs.getString("g_name"));
			g.setG_id(rs.getString("g_id"));
			g.setG_cate(rs.getString("g_cate"));
			g.setG_sangse(rs.getString("g_sangse"));
			g.setG_price(rs.getInt("g_price"));
			g.setG_date(rs.getString("g_date"));
			
			alm.add(g);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return alm;
	}
	
	
	// 상품 추가
	public void gInsert(Goods g) throws SQLException {
		System.out.println("gInsert 메서드 Gdao.java");
		int temp = 0;
		String result = null;
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT MAX(CAST(substr(g_code,2)AS DECIMAL)) AS g_code FROM ksmart_goods");
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("g_code"));
			temp = Integer.parseInt(rs.getString("g_code"))+1;
		}
		
		System.out.println(temp + "<-------gInsert 내 temp Gdao.java");
		result = "g"+temp;
		System.out.println(result + "<-------gInsert 내 result Gdao.java");
		
		pstmt = conn.prepareStatement("INSERT INTO ksmart_goods VALUES (?, ?, ?, ?, ?, ?, sysdate)");
		pstmt.setString(1, result);
		pstmt.setString(2, g.getG_name());
		pstmt.setString(3, g.getG_id());
		pstmt.setString(4, g.getG_cate());
		pstmt.setString(5, g.getG_sangse());
		pstmt.setInt(6, g.getG_price());
		rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		conn.close();
		
	}
	
	//상품 수정 리스트
	public Goods gUpdateSelect(String g_code) throws SQLException {
		System.out.println("gUpdateForm 메서드 Gdao.java");
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT * FROM ksmart_goods WHERE g_code=?");
		pstmt.setString(1, g_code);
		rs = pstmt.executeQuery();
		g = new Goods();
		
		while(rs.next()) {
			//g = new Goods();를 여기에썼다가 이러남
			// 이유는 밖에 이미 선언된 g가 리턴됨.. null...
			System.out.println(rs.getString("g_code")+"<<code gUpdateForm 메서드 Gdao.java");
			System.out.println(rs.getString("g_name")+"<<name gUpdateForm 메서드 Gdao.java");
			g.setG_code(rs.getString("g_code"));
			g.setG_name(rs.getString("g_name"));
			g.setG_id(rs.getString("g_id"));
			g.setG_cate(rs.getString("g_cate"));
			g.setG_sangse(rs.getString("g_sangse"));
			g.setG_price(rs.getInt("g_price"));
			g.setG_date(rs.getString("g_date"));
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return g;
	}
	
	public void gUpdatePro(Goods g) throws SQLException {
		
		System.out.println("gUpdatePro 메서드 Gdao.java");
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("UPDATE ksmart_goods SET g_name=?, g_cate=?, g_sangse=?, g_price=? WHERE g_code=?");
		pstmt.setString(1, g.getG_name());
		pstmt.setString(2, g.getG_cate());
		pstmt.setString(3, g.getG_sangse());
		pstmt.setInt(4, g.getG_price());
		pstmt.setString(5, g.getG_code());
		
		pstmt.executeUpdate();
	
		pstmt.close();
		conn.close();
	}
	

}
