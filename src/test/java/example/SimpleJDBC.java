package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJDBC {
	
	private String url = "jdbc:MySQL://localhost:3306/mywms";
	private String username = "root";
	private String password = "root";
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public SimpleJDBC(){
		
		try {
			
			//加载驱动 
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName("com.microsoft.jdbc.sqlserve.SQLServerDriver");
			Class.forName("com.MySQL.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void createConnection(){
		
		//创建连接//DataSource
		try {
			
			con = DriverManager.getConnection(url, username, password);
			
			//事务
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void closeConnection(){
		
		//关闭
		try {
			
			if(rs != null){
				rs.close();
			}
			
			if(stmt != null){
				stmt.close();
			}
			
			if(con != null){
				con.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void jdbcOracle() {

		try {
			
			createConnection();
			
			//ResultSet//RowSet
			rs = stmt.executeQuery("");
			
			//批量执行
			stmt.addBatch("");
			stmt.addBatch("");
			stmt.executeBatch();
			
			while(rs.next()){
				
				rs.getString("");
			}
			
			con.commit();
			
			con.setAutoCommit(true);
			
		} catch (Exception e) {
			
			try {
				
				con.rollback();
				con.setAutoCommit(true);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		} finally {
			
			closeConnection();
		}
	}
}