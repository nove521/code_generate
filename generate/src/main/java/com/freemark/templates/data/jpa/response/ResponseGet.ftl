package ${pacgePath};
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
<#list packNames! as pn>
import ${pn};
</#list>
import java.util.List;

@Data
public class ${className} {

    private List<${class?cap_first}> ${class};

    private int total;

    private int pageNo;

    private int pageSize = 10;

    @Data
    public static class ${class?cap_first} {
    <#list tableKey! as key>
        @ApiModelProperty("${key.annotation}")
        private ${key.type} ${tableKeyNameFormat[key_index]};

    </#list>
    }
}