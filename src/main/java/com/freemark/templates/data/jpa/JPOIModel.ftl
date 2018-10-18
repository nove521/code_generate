package ${pacgePath};
import lombok.Data;
import javax.persistence.*;
<#list packNames! as pn>
import ${pn};
</#list>

@Data
@Entity
@Table(name = "${tableName}")
public class ${className} {

<#list tableKey! as key>
    <#if key.isPrimary == 'true'>
    @Id
    <#if key.primaryIsAuto == 'YES'>
    @GeneratedValue(strategy = GenerationType.AUTO )
    </#if>
    </#if>
    @Column(name = "${key.name}")
    private ${key.type} ${tableKeyNameFormat[key_index]};

</#list>
}