package com.freemark.db;

import com.freemark.db.enpty.MySqlDbCulomEnpty;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;

public class MySqldbOperate implements DbOperate {

    private Connct connct;

    private MySqldbOperate(){}

    public MySqldbOperate(Connct connct){
        this.connct = connct;
    }

    public List<String> getCulomNames(String tableName) {
        try {
            DatabaseMetaData databaseMetaData = connct.getConnection().getMetaData();
            ResultSet tableRet = databaseMetaData.getColumns(null,"%",tableName,"%");
            while(tableRet.next()){
                System.out.println(tableRet.getString("COLUMN_NAME"));
                System.out.println(tableRet.getString("TYPE_NAME"));
                System.out.println(tableRet.getInt("COLUMN_SIZE"));
                System.out.printf(tableRet.getString("REMARKS"));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MySqlDbCulomEnpty> getCuloms(String tableName) {
        return null;
    }
}
