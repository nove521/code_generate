package ${pacgePath};
//import lombok.Data;
<#list packNames! as pn>
import ${pn};
</#list>

public class ${className} {

<#list tableKey! as key>
    // ${key.annotation}
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