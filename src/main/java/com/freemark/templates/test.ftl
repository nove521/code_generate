package ${pacgePath};

public class ${className} {

<#list tableKey! as key>
    private ${key.type} ${key.name};
</#list>

<#list tableKey! as key>
    public void set${key.name?cap_first}(${key.type} ${key.name}){
        this.${key.name}=${key.name};
    }

    public ${key.type} get${key.name?cap_first}(){
        return this.${key.name};
    }

</#list>
}