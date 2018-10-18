package ${pacgePath};
import lombok.Data;
<#list packNames! as pn>
import ${pn};
</#list>

@Data
public class ${className} {

    private Integer pageNo;
    private Integer pageSize;
<#list tableKey! as key>
    // ${key.annotation}
    private ${key.type} ${tableKeyNameFormat[key_index]};

</#list>
}