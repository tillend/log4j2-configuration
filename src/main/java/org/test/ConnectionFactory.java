package org.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class ConnectionFactory {
	private static interface Singleton {
		final ConnectionFactory INSTANCE = new ConnectionFactory();
	}

	private DataSource dataSource = null;

	private ConnectionFactory() {
		Properties properties = new Properties();
		//从配置文件读取properties,亦可直接赋值至Properties实例中
		//driverClassName,url,username,password为必须项
		try (InputStream is = ConnectionFactory.class.getResourceAsStream("/jdbc.properties")){
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			this.dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getDatabaseConnection() throws SQLException {
		return Singleton.INSTANCE.dataSource.getConnection();
	}
}