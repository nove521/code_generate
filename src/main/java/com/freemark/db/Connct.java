package com.freemark.db;

import java.sql.*;

public class Connct {

    private Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/%s";
    private static String driver = "com.mysql.cj.jdbc.Driver";

    private Connct(){

    }

    public Connct(String username, String pasw, String db){
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(String.format(url, db),username,pasw);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception {
        if (null != this.conn){
            return this.conn;
        }
        throw new Exception("not have conn");
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mtest","root","root");
            Statement state = conn.createStatement();
            ResultSet resultSet = state.executeQuery("select  * from t1");
            resultSet.getRow();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
