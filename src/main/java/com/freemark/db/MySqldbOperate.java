package com.freemark.db;

import com.freemark.db.enpty.MySqlDbCulomEnpty;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqldbOperate implements DbOperate {

    private Connct connct;

    private MySqldbOperate(){}

    public MySqldbOperate(Connct connct){
        this.connct = connct;
    }

    public List<String> getCulomNames(String tableName,String db) {
        return null;
    }
    private List<MySqlDbCulomEnpty> getCulomByPk(String tableName,String db,DatabaseMetaData databaseMetaData) throws SQLException {
        List<MySqlDbCulomEnpty> mySqlDbCulomEnpties = new ArrayList<MySqlDbCulomEnpty>();
        ResultSet pkRSet = databaseMetaData.getPrimaryKeys("mtest", null, "t1");
        while( pkRSet.next() ) {
            MySqlDbCulomEnpty mySqlDbCulomEnpty = new MySqlDbCulomEnpty();
            mySqlDbCulomEnpty.setName(pkRSet.getString("COLUMN_NAME"));
            mySqlDbCulomEnpties.add(mySqlDbCulomEnpty);
        }
        return mySqlDbCulomEnpties;
    }

    public List<MySqlDbCulomEnpty> getCuloms(String tableName,String db) {
        List<MySqlDbCulomEnpty> mySqlDbCulomEnpties = new ArrayList<MySqlDbCulomEnpty>();
        try {
            DatabaseMetaData databaseMetaData = connct.getConnection().getMetaData();
            ResultSet tableRet = databaseMetaData.getColumns(null,"%",tableName,"%");
          /*  while(tableRet.next()){
                System.out.println(tableRet.getString("COLUMN_NAME"));
                System.out.println(tableRet.getString("TYPE_NAME"));
                System.out.println(tableRet.getInt("COLUMN_SIZE"));
                System.out.printf(tableRet.getString("REMARKS"));
            }*/
            mySqlDbCulomEnpties.addAll(getCulomByPk(tableName,db,databaseMetaData));
            return mySqlDbCulomEnpties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
