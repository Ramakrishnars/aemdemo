package com.aem.core.dbutils;

import java.sql.Connection;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.commons.datasource.poolservice.DataSourcePool;



@Component(immediate=true, service=DatabaseConnectionHelper.class)
public class DatabaseConnectionHelper {
	private Logger log=LoggerFactory.getLogger(DatabaseConnectionHelper.class);
	  @Reference
	  DataSourcePool source;
	  public Connection getDataBaseConnection(String datasourceName){
		  DataSource dataSource=null;
		  Connection con=null;
		  try {
			  log.debug("inside connection source is {}", source );
			  dataSource=(DataSource)source.getDataSource(datasourceName);
			  con=dataSource.getConnection();
			  log.info("connection success in databaseservice"+con);
			  
			  return con;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			log.error("Error occured while establishing connection ::: {}",e);
		}
		  return null;
	  }
}
