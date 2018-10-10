package com.freemark.db;

import com.freemark.db.enpty.MySqlDbCulomEnpty;

import java.util.List;

public interface DbOperate {

    /**
     * 获取字段名
     * @return
     */
    List<String> getCulomNames(String tableName);

    /**
     * 获取字段
     * @return
     */
    List<MySqlDbCulomEnpty> getCuloms(String tableName);

}
