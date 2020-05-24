package com.org.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.org.student.dao.StudentDAO;
import com.org.student.vo.Student;

public class StudentDAOImpl implements StudentDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public StudentDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	@Override
	public boolean addMessage(Student student) throws Exception {
		boolean falg = false;
		String sql = "insert into student values(?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student.getSid());
		this.pstmt.setString(2, student.getSname());
		this.pstmt.setString(3, student.getSbirthday());
		this.pstmt.setInt(4, student.getSsex());
		if(this.pstmt.executeUpdate()>0) {
			falg = true;
		}
		this.conn.close();
		return falg;
	}

	@Override
	public boolean UpdateMessage(Student s) throws Exception {
		boolean falg=false;
		String sql = "update student set sname = ?,sbirthday = ?,ssex = ? where sid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, s.getSname());
		this.pstmt.setString(2, s.getSbirthday());
		this.pstmt.setInt(3, s.getSsex());
		this.pstmt.setString(4, s.getSid());
		if(this.pstmt.executeUpdate()>0) {
			falg = true;
		}
		this.conn.close();
		return falg;
	}

	@Override
	public boolean DeleteMessage(String sid) throws Exception {
		boolean falg=false;
		String sql = "delete from student where sid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, sid);
		if(this.pstmt.executeUpdate()>0) {
			falg = true;
		}
		this.conn.close();
		return falg;
	}

	@Override
	public ArrayList<Student> findAll() throws Exception {
		ArrayList<Student> sList = new ArrayList<Student>();
		String sql = "select * from student";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Student s = new Student();
			s.setSid(rs.getString(1));
			s.setSname(rs.getString(2));
			s.setSbirthday(rs.getString(3));
			s.setSsex(rs.getInt(4));
			sList.add(s);
		}
		this.conn.close();
		return sList;
	}

	@Override
	public ArrayList<Student> termFind(String info) throws Exception {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "select * from student where sid like ? or sname like ? or sbirthday  like binary  ? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + info + "%");
		this.pstmt.setString(2, "%" + info + "%");
		this.pstmt.setString(3, "%" + info + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			Student student = new Student();
			student.setSid(rs.getString(1));
			student.setSname(rs.getString(2));
			student.setSbirthday(rs.getString(3));
			list.add(student);		
		}
		this.conn.close();
		return list;
	}
}

