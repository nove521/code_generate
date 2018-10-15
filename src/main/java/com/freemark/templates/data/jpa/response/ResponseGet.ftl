package ${pacgePath};
//import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
<#list packNames! as pn>
import ${pn};
</#list>
import java.util.List;

public class ${className} {

    private List<${class?cap_first}> ${class};

    private int total;

    private int pageNo;

    private int pageSize = 10;

    public List<${class?cap_first}> get${class?cap_first}() {
        return ${class};
    }

    public void set${class?cap_first}(List<${class?cap_first}> ${class}) {
        this.${class} = ${class};
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

    public static class ${class?cap_first} {
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