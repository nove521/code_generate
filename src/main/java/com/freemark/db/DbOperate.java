package com.freemark.db;

import com.freemark.db.enpty.MySqlDbCulomEnpty;

import java.util.List;
import java.util.Map;

public interface DbOperate {

    /**
     * 获取字段名
     * @return
     */
    List<String> getCulomNames(String tableName,String db);

    /**
     * 获取字段信息
     * @return
     */
    Map<String,MySqlDbCulomEnpty> getCulomsMap(String tableName, String db);

    List<MySqlDbCulomEnpty> getCulomsList(Map<String,MySqlDbCulomEnpty> map);
    List<MySqlDbCulomEnpty> getCulomsList(String tableName, String db);
}
