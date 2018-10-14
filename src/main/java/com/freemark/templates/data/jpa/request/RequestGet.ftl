package ${pacgePath};
//import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
<#list packNames! as pn>
import ${pn};
</#list>

public class ${className} {

<#list tableKey! as key>
    @ApiModelProperty("${key.annotation}")
    private ${key.type} ${tableKeyNameFormat[key_index]};

</#list>
    private Integer pageNo = 1;

    private Integer pageSize = 10;

<#list tableKey! as key>
    public void set${tableKeyNameFormat[key_index]} (${key.type} ${tableKeyNameFormat[key_index]}){
        this.${tableKeyNameFormat[key_index]}=${tableKeyNameFormat[key_index]};
    }

    public ${key.type} get${tableKeyNameFormat[key_index]?cap_first}(){
        return this.${tableKeyNameFormat[key_index]};
    }

</#list>
    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}