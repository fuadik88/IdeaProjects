package com.customer_tracker.testdb;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

import java.sql.Connection;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "TestDB", value = "/TestDB")
public class TestDB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //setup connection variables
        String DB_URL = "jdbc:oracle:thin:@oraclesql_medium?TNS_ADMIN=/Users/user/Desktop/Fuad/Wallet_OracleSQL/";
        String DB_USER = "HBSPRINGMVC";
        String DB_PASS = "Filtd0102@asd";
        String CONN_FACTORY_CLASS_NAME = "oracle.jdbc.pool.OracleDataSource";
        PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
        try {
            pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
            pds.setURL(DB_URL);
            pds.setUser(DB_USER);
            pds.setPassword(DB_PASS);
            pds.setConnectionPoolName("JDBC_UCP_POOL");

            pds.setInitialPoolSize(5);
            pds.setMaxPoolSize(20);

            PrintWriter msg = response.getWriter();
            Connection conn = pds.getConnection();
            System.out.println("Successful Database Connection!");
            msg.println("<html><title>DB connection</title><body><h1 style=\"color:magenta;\">Connection Successful!" +
                    "</h1></body></html>");
            conn.close();
            conn = pds.getConnection();
            Statement st = conn.createStatement();
            st.execute("delete from CUSTOMER where FIRST_NAME IS NULL");
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
