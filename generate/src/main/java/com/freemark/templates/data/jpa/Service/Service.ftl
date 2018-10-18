package ${pacgePath};

import ${pagePacgePath};
import ${boPacgePath}.${class?cap_first}Bo;
import ${EntityPacgePath}.${class?cap_first}Entity;

public interface ${className} {

    Page<${class?cap_first}Entity> query${class?cap_first}(${class?cap_first}Bo ${class}Bo);

    void add${class?cap_first}(${class?cap_first}Bo ${class}Bo);

    void update${class?cap_first}(${class?cap_first}Bo ${class}Bo);

    void delete${class?cap_first}(int id);
}
