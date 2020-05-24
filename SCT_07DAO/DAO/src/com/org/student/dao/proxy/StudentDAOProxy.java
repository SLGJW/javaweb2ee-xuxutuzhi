package com.org.student.dao.proxy;

import java.util.ArrayList;

import com.org.student.dao.StudentDAO;
import com.org.student.dao.impl.StudentDAOImpl;
import com.org.student.dbc.DatabaseConnection;
import com.org.student.vo.Student;

public class StudentDAOProxy implements StudentDAO {
	
	private DatabaseConnection dbc = null;
	private StudentDAO dao = null;
	public StudentDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new StudentDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean addMessage(Student student) throws Exception {
		boolean falg=false;
		if (this.dao.addMessage(student)) {
			falg = true;
		}
		this.dbc.close();
		return falg;
	}

	@Override
	public boolean UpdateMessage(Student s) throws Exception {
		boolean falg=false;
		if (this.dao.UpdateMessage(s)) {
			falg = true;
		}
		this.dbc.close();
		return falg;
	}

	@Override
	public boolean DeleteMessage(String sid) throws Exception {
		boolean falg=false;
		if (this.dao.DeleteMessage(sid)) {
			falg = true;
		}
		this.dbc.close();
		return falg;
	}

	@Override
	public ArrayList<Student> findAll() throws Exception {
		ArrayList<Student> list = null;
		list = this.dao.findAll();
		this.dbc.close();
		return list;
	}

	@Override
	public ArrayList<Student> termFind(String info) throws Exception {
		ArrayList<Student> list = null;
		list = this.dao.termFind(info);
		this.dbc.close();
		return list;
	}

}
