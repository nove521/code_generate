package ${pacgePath};

import ${BaseDaoPacgePath};
import ${pagePacgePath};
import ${EntityPacgePath}.${class?cap_first}Entity;
import ${voPacgePath}.${class?cap_first}Vo;

public interface ${className} extends BaseDao<${class?cap_first}Entity,${class?cap_first}Vo>{
    Page<${class?cap_first}Entity> query${class?cap_first}(${class?cap_first}Vo ${class}Vo);

    void add${class?cap_first}(${class?cap_first}Vo ${class}Vo);

    void update${class?cap_first}(${class?cap_first}Vo ${class}Vo);

    void delete${class?cap_first}(int id);
}