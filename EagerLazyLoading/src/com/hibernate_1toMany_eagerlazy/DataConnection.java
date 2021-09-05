package com.hibernate_1toMany_eagerlazy;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnection {
    static final String DB_URL = "jdbc:oracle:thin:@oraclesql_medium?TNS_ADMIN=/Users/user/Desktop/Fuad/Wallet_OracleSQL/";
    static final String DB_USER = "HBSTUDENT";
    static final String DB_PASS = "Filtd0102@asd";
    static final String CONN_FACTORY_CLASS_NAME = "oracle.jdbc.pool.OracleDataSource";

    public static ResultSet execute(String sql) throws Exception {
        PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();

        pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
        pds.setURL(DB_URL);
        pds.setUser(DB_USER);
        pds.setPassword(DB_PASS);
        pds.setConnectionPoolName("JDBC_UCP_POOL");

        pds.setInitialPoolSize(5);
        pds.setMaxPoolSize(20);

        Connection conn;

        try {
            conn = pds.getConnection();
            System.out.println("Successful database connection!");
            Thread.sleep(2000);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("Successful query");
            return rs;

        } catch (SQLException se) {
            System.out.println("Error occurred.");
            System.out.println(se.getMessage());
            return null;
        }
    }
}
