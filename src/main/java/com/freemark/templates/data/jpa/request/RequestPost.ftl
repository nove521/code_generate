package ${pacgePath};
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
<#list packNames! as pn>
import ${pn};
</#list>

@Data
public class ${className} {

<#list tableKey! as key>
    @ApiModelProperty("${key.annotation}")
    private ${key.type} ${tableKeyNameFormat[key_index]};

</#list>

}