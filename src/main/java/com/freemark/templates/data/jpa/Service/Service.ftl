package ${pacgePath};

import ${voPacgePath}.${class?cap_first}Vo;
import ${pagePacgePath};
import ${boPacgePath}.${class?cap_first}Bo;

public interface ${className} {

    Page<${class?cap_first}Vo> query${class?cap_first}(${class?cap_first}Bo ${class}Bo);

    void add${class?cap_first}(${class?cap_first}Bo ${class}Bo);

    void update${class?cap_first}(${class?cap_first}Bo ${class}Bo);

    void delete${class?cap_first}(int id);
}
