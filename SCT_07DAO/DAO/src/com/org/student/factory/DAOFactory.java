package com.org.student.factory;


import com.org.student.dao.StudentDAO;
import com.org.student.dao.proxy.StudentDAOProxy;

public class DAOFactory {
	public static StudentDAO getStudentDAOImplInstanse() throws Exception {
		return new StudentDAOProxy();
	}
}
