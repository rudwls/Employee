package com.hybrid.transfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class xxx {
	static Log log = LogFactory.getLog(xxx.class);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String clsname = "oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@l92.168.10.16:1521:xe";
//		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="spring";
		String password="tiger";
		
		Class.forName(clsname);
		Connection con = DriverManager.getConnection(url, user, password);
		
		log.info("db = " + con.getMetaData().getDatabaseProductName());
		
		
	}
	
	static void xxx() throws SQLException {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		BasicDataSource ds = ctx.getBean(BasicDataSource.class);
		Connection con = ds.getConnection();
		
		log.info("db = " + con.getMetaData().getDatabaseProductName());
		
		
		ctx.close();
	}

}
