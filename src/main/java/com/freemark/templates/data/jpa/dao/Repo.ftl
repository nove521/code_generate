package ${pacgePath};

import ${EntityPacgePath}.${class?cap_first}Entity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ${className} extends CrudRepository<${class?cap_first}Entity,Integer>,JpaSpecificationExecutor<${class?cap_first}Entity> {

}
