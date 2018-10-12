package com.freemark.db;

import com.freemark.db.enpty.MySqlDbCulomEnpty;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySqldbOperate implements DbOperate {

    private Connct connct;

    private MySqldbOperate() {
    }

    public MySqldbOperate(Connct connct) {
        this.connct = connct;
    }

    public List<String> getCulomNames(String tableName, String db) {
        return null;
    }

    /**
     * 获取主键信息
     *
     * @param tableName
     * @param db
     * @param databaseMetaData
     * @return
     * @throws SQLException
     */
    private List<MySqlDbCulomEnpty> getCulomByPk(String tableName, String db, DatabaseMetaData databaseMetaData) throws SQLException {
        List<MySqlDbCulomEnpty> mySqlDbCulomEnpties = new ArrayList<MySqlDbCulomEnpty>();
        ResultSet pkRSet = databaseMetaData.getPrimaryKeys(db, null, tableName);
        while (pkRSet.next()) {
            MySqlDbCulomEnpty mySqlDbCulomEnpty = new MySqlDbCulomEnpty();
            mySqlDbCulomEnpty.setName(pkRSet.getString("COLUMN_NAME"));
            mySqlDbCulomEnpties.add(mySqlDbCulomEnpty);
        }
        return mySqlDbCulomEnpties;
    }

    public HashMap<String, MySqlDbCulomEnpty> getCulomsMap(String tableName, String db) {
        HashMap<String, MySqlDbCulomEnpty> maps = new HashMap<String, MySqlDbCulomEnpty>();
        try {
            DatabaseMetaData databaseMetaData = connct.getConnection().getMetaData();
            ResultSet tableRet = databaseMetaData.getColumns(null, "%", tableName, "%");
            while (tableRet.next()) {
                MySqlDbCulomEnpty culomEnpty = new MySqlDbCulomEnpty();
                culomEnpty.setName(tableRet.getString("COLUMN_NAME"));
                culomEnpty.setAnnotation(tableRet.getString("REMARKS"));
                culomEnpty.setCanNull(tableRet.getBoolean("NULLABLE"));
                culomEnpty.setStrDefault(tableRet.getString("COLUMN_DEF"));
                culomEnpty.setType(tableRet.getString("TYPE_NAME"));
                culomEnpty.setTypeLong(tableRet.getString("COLUMN_SIZE"));
                culomEnpty.setPrimaryIsAuto(tableRet.getString("IS_AUTOINCREMENT"));
                maps.put(culomEnpty.getName(), culomEnpty);
            }
            maps = getTotalCuloms(maps,getCulomByPk(tableName,db,databaseMetaData));
            return maps;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MySqlDbCulomEnpty> getCulomsList(Map<String, MySqlDbCulomEnpty> map) {
        List<MySqlDbCulomEnpty> list = new ArrayList<>();
        map.forEach((k,v)->{
            list.add(v);
        });
        return list;
    }

    @Override
    public List<MySqlDbCulomEnpty> getCulomsList(String tableName, String db) {
        return getCulomsList(getCulomsMap(tableName,db));
    }

    /**
     * 设置主键
     */
    private HashMap<String, MySqlDbCulomEnpty> getTotalCuloms(HashMap<String, MySqlDbCulomEnpty> mpas, List<MySqlDbCulomEnpty> pkList) {

        for (MySqlDbCulomEnpty operate : pkList) {
            MySqlDbCulomEnpty culomEnpty = mpas.get(operate.getName());
            if (null != culomEnpty){
                culomEnpty.setPrimary(true);
                mpas.put(culomEnpty.getName(),culomEnpty);
            }
        }
        return mpas;

    }
}
