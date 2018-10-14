package ${pacgePath};
//import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
<#list packNames! as pn>
import ${pn};
</#list>
import java.util.List;

public class ${className} {

    private List<${tableName?cap_first}> ${tableName};

    private int total;

    private int pageNo;

    private int pageSize = 10;

    public List<${tableName?cap_first}> get${tableName?cap_first}() {
        return ${tableName};
    }

    public void set${tableName?cap_first}(List<${tableName?cap_first}> ${tableName}) {
        this.${tableName} = ${tableName};
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public static class ${tableName?cap_first} {
    <#list tableKey! as key>
        @ApiModelProperty("${key.annotation}")
        private ${key.type} ${tableKeyNameFormat[key_index]};

    </#list>
    <#list tableKey! as key>
        public void set${tableKeyNameFormat[key_index]} (${key.type} ${tableKeyNameFormat[key_index]}){
            this.${tableKeyNameFormat[key_index]}=${tableKeyNameFormat[key_index]};
        }

        public ${key.type} get${tableKeyNameFormat[key_index]?cap_first}(){
            return this.${tableKeyNameFormat[key_index]};
        }

    </#list>
    }

}