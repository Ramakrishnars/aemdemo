package com.aem.core.serviceimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.core.been.Employ;
import com.aem.core.dbutils.DatabaseConnectionHelper;
import com.aem.core.services.EmployeeI;

@Component(immediate=true, service=EmployeeI.class)
public class EmployeeImpl implements EmployeeI {
private static final Logger log=LoggerFactory.getLogger(EmployeeImpl.class);

@Reference
private DatabaseConnectionHelper connectionhlpr;

Connection con=null;
PreparedStatement pstmt=null;



	@Override
	public boolean addEmployee(Employ emp) {
		// TODO Auto-generated method stub
		
		log.info("Employee Register invoked");
		String sqlQuery="insert into employ values(?,?,?,?)";
		boolean flag=false;
		try {
			con=connectionhlpr.getDataBaseConnection("shiva");
			pstmt=con.prepareStatement(sqlQuery);
			pstmt.setString(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpSal());
			pstmt.setString(4, emp.getEmpAddr());
			int i=pstmt.executeUpdate();
			if(i==1){
				flag=true;
				log.info("Record is inserted successfully");
			}
			else{
				flag=false;
				log.info("Record is not inserted successfully");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					pstmt.close();
					con.close();
					
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		}
		log.info("Employee Register End");
		return flag;
	}

}