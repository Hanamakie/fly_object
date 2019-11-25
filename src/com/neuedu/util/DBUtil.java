package com.neuedu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	//声明各项参数变量，不给赋值
	private static Connection conn;
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//静态代码块中为连接数据库用到的各项参数赋值
	static{
		//项目中新建了一个properties文件，因此需要Properties这个类的对象获取这个文件中的参数
		Properties prop = new Properties();
		try {
			//找到db.properties文件所在路径，并且读取，因此db.properties中的各项参数已经封装到
			//prop对象中
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//把prop中装载好的各项参数赋值给以前声明好的变量
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
	}
	//把构造方法变为私有，防止外界随意创建DBUtil的对象
	private DBUtil(){
		
	}
	//公有静态的方法，作用是获得连接对象
	public static Connection getConnection(){
		//如果conn为空或者已经关闭，重新创建连接对象
		try {
			if(conn == null || conn.isClosed()){
				//加载驱动
				Class.forName(driver);
				//创建连接
				conn = DriverManager.getConnection(url, username, password);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
