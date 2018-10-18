package ${pacgePath};

import ${voPacgePath}.${class?cap_first}Vo;
import ${EntityPacgePath}.${class?cap_first}Entity;
import ${pagePacgePath};
import ${DaoPacgePath}.${class?cap_first}Dao;
import ${RepoPacgePath}.${class?cap_first}Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

@Repository
public class ${className}Impl implements ${className}{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ${class?cap_first}Repo ${class}Repo;

    @Override
    public Page<${class?cap_first}Entity> query${class?cap_first}(${class?cap_first}Vo ${class}Vo){

        StringBuilder sql = new StringBuilder();
        List param = new ArrayList();
        sql.append("select SQL_CALC_FOUND_ROWS * from ${tableName} where 1=1");
    <#list tableKey! as key>
        <#if key.type == "String">
        if (StringUtils.isNotEmpty(${class}Vo.get${tableKeyNameFormat[key_index]?cap_first}())) {
            sql.append(" and ${key.name} = ?");
            param.add(${class}Vo.get${tableKeyNameFormat[key_index]?cap_first}());
         }
        <#else>
        if (null != ${class}Vo.get${tableKeyNameFormat[key_index]?cap_first}()) {
            sql.append(" and ${key.name} = ?");
            param.add(${class}Vo.get${tableKeyNameFormat[key_index]?cap_first}());
        }
        </#if>
    </#list>
        sql.append(" limit ?,?");
        param.add((${class}Vo.getPageNo() - 1) * ${class}Vo.getPageSize());
        param.add(${class}Vo.getPageSize());
        RowMapper<${class?cap_first}Entity> rowMapper = new BeanPropertyRowMapper<>(${class?cap_first}Entity.class);
        List<${class?cap_first}Entity> query = jdbcTemplate.query(sql.toString(), param.toArray(), rowMapper);
        final String totalSql = "SELECT FOUND_ROWS();";
        Integer total = jdbcTemplate.queryForObject(totalSql, Integer.class);
        Page<${class?cap_first}Entity> page = new Page<>();
        page.setData(query);
        page.setCurrentPage(${class}Vo.getPageNo());
        page.setPageSize(${class}Vo.getPageSize());
        page.setTotal(total);
        return page;

    }

    @Override
    public void add${class?cap_first}(${class?cap_first}Vo ${class}Vo){
        ${class?cap_first}Entity entity = new ${class?cap_first}Entity();
        BeanUtils.copyProperties(${class}Vo,entity);
        ${class}Repo.save(entity);
    }

    @Override
    public void update${class?cap_first}(${class?cap_first}Vo ${class}Vo){
        ${class?cap_first}Entity entity = ${class}Repo.findOne(${class}Vo.getId());
        BeanUtils.copyProperties(${class}Vo,entity);
        ${class}Repo.save(entity);
    }

    @Override
    public void delete${class?cap_first}(int id){
       ${class?cap_first}Entity entity = ${class}Repo.findOne(id);
       if ( null !=entity ){
           ${class}Repo.delete(id);
       }
    }

}
