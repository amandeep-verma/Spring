package com.telusko.demoRest2;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class AlienRepository {

	Connection con = null;
	
	public AlienRepository() {
		String url = "jdbc:mysql://localhost:3306/restdb?serverTimezone=EST";
		String username="root";
		String password="Dingo@12";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Alien> getaliens()
	{
		List<Alien> li = new ArrayList<Alien>();
		String sql = "Select * from alien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				li.add(a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return li;
	}
	
	
	public Alien getalien(int id)
	{
		String sql = "Select * from alien where id="+id;
		Alien a = new Alien();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public void create(Alien a1) {
		String sql = "Insert into alien values (?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("New Alien added");
	}
	
	
	public void update(Alien a1) {
		String sql = "update alien set name =?, points=? where id = ?";
		int num=0;
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, a1.getName());
			st.setInt(2, a1.getPoints());
			st.setInt(3, a1.getId());
			
			num = st.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Alien updated "+num+ " enteries");
	}

	public void delete(int id) {
		String sql = "delete from  alien where id = ?";
		int num=0;
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			
			num = st.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Alien deleted "+num+ " enteries");
		
	}
	
	
	
}
