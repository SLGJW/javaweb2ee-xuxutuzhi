package com.org.student.dao;

import java.util.ArrayList;

import com.org.student.vo.Student;

public interface StudentDAO {
	public boolean addMessage(Student student) throws Exception;
	public boolean UpdateMessage(Student s) throws Exception;
	public boolean DeleteMessage(String sid) throws Exception;
	public ArrayList<Student> findAll() throws Exception;
	public ArrayList<Student> termFind(String info) throws Exception;
	
	
}
