package ${pacgePath};

import ${pagePacgePath};
import ${ProjdectRootpacgePath}.framework.utils.DateUtils;
import ${ServicePacgePath}.${class?cap_first}Service;
import ${boPacgePath}.${class?cap_first}Bo;
import ${RequestGetPacgePath}.Request${class?cap_first}Get;
import ${ResponseGetPacgePath}.Response${class?cap_first}Get;
import ${RequestPostPacgePath}.Request${class?cap_first}Post;
import ${EntityPacgePath}.${class?cap_first}Entity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/manager/admin/{adminUser}/${tableName?replace("_","-")}")
@Api(tags = {"模块"})
public class ${className} {

    @Autowired
    private ${class?cap_first}Service ${class}Service;

    @ApiOperation(value = "查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Response${class?cap_first}Get query${class?cap_first}(Request${class?cap_first}Get request ) {
        ${class?cap_first}Bo ${class}Bo = new ${class?cap_first}Bo();
        BeanUtils.copyProperties(request,${class}Bo);

        Response${class?cap_first}Get response = new Response${class?cap_first}Get();
        List<Response${class?cap_first}Get.${class?cap_first}> result = new ArrayList<>();
        Page<${class?cap_first}Entity> page = ${class}Service.query${class?cap_first}(${class}Bo);
        page.getData().forEach(e -> {
            Response${class?cap_first}Get.${class?cap_first} ${class} = new Response${class?cap_first}Get.${class?cap_first}();
            BeanUtils.copyProperties(e, ${class});
        <#list  tableKey! as key>
            <#if key.type == "LocalDateTime">
            ${class}.set${tableKeyNameFormat[key_index]}(DateUtils.getDateLocalDateTimeStr(e.get${tableKeyNameFormat[key_index]?cap_first}(), "yyyy-MM-dd HH:mm:ss"));
            </#if>
        </#list>
            result.add(${class});
        });
        response.setTotal(page.getTotal());
        response.set${class?cap_first}(result);
        return response;
    }

    @ApiOperation(value = "添加")
    @RequestMapping(value = "/item",method = RequestMethod.POST)
    public void add${class?cap_first}(@RequestBody Request${class?cap_first}Post request) {

        ${class?cap_first}Bo ${class}Bo = new ${class?cap_first}Bo();
        BeanUtils.copyProperties(request,${class}Bo);
        ${class}Service.add${class?cap_first}(${class}Bo);

    }

     @ApiOperation(value = "删除")
     @RequestMapping(value = "/{id}/item",method = RequestMethod.DELETE)
     public void delete${class?cap_first}(@PathVariable(value = "id") Integer id) {
        ${class}Service.delete${class?cap_first}(id);
     }

     @ApiOperation(value = "修改")
     @RequestMapping(value = "/{id}/item",method = RequestMethod.PATCH)
     public void update${class?cap_first}(Request${class?cap_first}Post request){
        ${class?cap_first}Bo ${class}Bo = new ${class?cap_first}Bo();
        BeanUtils.copyProperties(request,${class}Bo);
        ${class}Service.update${class?cap_first}(${class}Bo);
     }

}
