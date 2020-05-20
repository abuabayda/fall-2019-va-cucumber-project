package com.cybertek.library.step_definitions;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.sql.*;

public class JDBCReview {
  /*
  In my project i used mysql DB , but prior to that i have worked with oracle DB as well,
  i have done manual testing as well as automated testing on DB.
  in Java there is JDBC api tht handles connections to DB . so this is what i used in my project to connect to DB and automate
      -> first based of type of DB , i need ti add driver to project , since i used maven , i added to the pom file, for Mysql
      mysql-connector-java driver , for oracle jdbc driver, next i need create connection for this i use connection class in java/JDBC
      need url , username ,password, required
      after connection is created , use statement class to execute queries and ResultSet class to store query result and interact with it
   */
  @Test
  public void testConnection() throws SQLException {

    String url = "jdbc:mysql://ec2-18-233-97-71.compute-1.amazonaws.com:3306/library2";
    String username = "library2_client";
    String password = "6s2LQQTjBcGFfDhY";
    Connection connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet resultSet = statement.executeQuery("select full_name , email from users order by full_name");
    System.out.println(resultSet.getMetaData().getColumnName(1));
    
    //get all column names
    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
      System.out.print(resultSet.getMetaData().getColumnName(i)+"\t");
    }

    System.out.println();
    //print all data from resultSet

    while (resultSet.next()){
      for (int i = 1 ; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.print(resultSet.getString(i)+"\t");
      }
      System.out.println();
    }

  }
}
