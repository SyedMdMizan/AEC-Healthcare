package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
	private Connection conn;

	
	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
	}


	public boolean registerDoctor(Doctor d)
	{
		boolean f=false;
		try {
			String sql = "insert into doctor(full_name, dob, qualification, email, mobno, password) values( ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getEmail());
			ps.setString(5, d.getMobNo());
			ps.setString(6, d.getPassword());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Doctor> getAllDoctor()
	{
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d=null;
		try {
			String sql = "select * from doctor order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setEmail(rs.getString(5));
				d.setMobNo(rs.getString(6));
				d.setPassword(rs.getString(7));
				list.add(d);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Doctor getDoctorById(int id)
	{
		Doctor d=null;
		try {
			String sql = "select * from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setEmail(rs.getString(5));
				d.setMobNo(rs.getString(6));
				d.setPassword(rs.getString(7));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public boolean updateDoctor(Doctor d)
	{
		boolean f=false;
		try {
			String sql = "update doctor set full_name=?, dob=?, qualification=?, email=?, mobno=?, password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getEmail());
			ps.setString(5, d.getMobNo());
			ps.setString(6, d.getPassword());
			ps.setInt(7, d.getId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteDoctor(int id)
	{
		boolean f=false;
		try {
			String sql="delete from doctor where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public Doctor login(String email, String psw)
	{
		Doctor d=null;
		try {
			String sql = "select * from doctor where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setEmail(rs.getString(5));
				d.setMobNo(rs.getString(6));
				d.setPassword(rs.getString(7));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public int countDoctor() {
		int i=0;
		try {
			String sql = "select * from doctor";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countAppointment() {
		int i=0;
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countUser() {
		int i=0;
		try {
			String sql = "select * from user";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countSpecialist() {
		int i=0;
		try {
			String sql = "select distinct qualification from doctor";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countAppointmentByDoctorId(int did) {
		int i=0;
		try {
			String sql = "select * from appointment where doctor_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
