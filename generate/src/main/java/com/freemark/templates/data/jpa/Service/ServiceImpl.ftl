<#assign cname = class + "Dao">
package ${pacgePath};

import ${voPacgePath}.${class?cap_first}Vo;
import ${pagePacgePath};
import ${boPacgePath}.${class?cap_first}Bo;
import ${ServicePacgePath}.${class?cap_first}Service;
import ${DaoPacgePath}. ${class?cap_first}Dao;
import ${EntityPacgePath}.${class?cap_first}Entity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ${className}Impl implements ${className}{

    @Autowired
    private ${class?cap_first}Dao ${class}Dao;

    @Override
    public Page<${class?cap_first}Entity> query${class?cap_first}(${class?cap_first}Bo ${class}Bo){
        ${class?cap_first}Vo ${class}Vo = new ${class?cap_first}Vo();
        BeanUtils.copyProperties(${class}Bo,${class}Vo);
        return ${cname}.getPage(${class}Vo);
    }

    @Override
    public void add${class?cap_first}(${class?cap_first}Bo ${class}Bo){
        ${class?cap_first}Entity entity = new ${class?cap_first}Entity();
        BeanUtils.copyProperties(${class}Bo,entity);
        ${cname}.save(entity);
    }

    @Override
    public void update${class?cap_first}(${class?cap_first}Bo ${class}Bo){
        ${class?cap_first}Entity entity = ${class}Repo.findOne(${class}Bo.getId());
        BeanUtils.copyProperties(${class}Bo,entity);
        ${cname}.save(entity);
    }

    @Override
    public void delete${class?cap_first}(int id){
        ${class?cap_first}Entity entity = ${class}Repo.findOne(id);
        if ( null !=entity ){
            ${cname}.delete(id);
        }
    }

}
