package ${pacgePath};
import lombok.Data;
<#list packNames! as pn>
import ${pn};
</#list>

@Data
public class ${className} {

    private Integer pageNo = 1;
    private Integer pageSize = 10;
<#list tableKey! as key>
    private ${key.type} ${tableKeyNameFormat[key_index]};
</#list>

}