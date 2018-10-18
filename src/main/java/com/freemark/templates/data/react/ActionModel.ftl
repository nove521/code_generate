import alt from 'app/alt';
import RestAPI from 'utils/rest-api';
import {message} from 'antd';
import {map} from 'lodash/fp';
import ${class?cap_first}Store from 'store/${class?cap_first}Store';
import Config from 'app/common';

class ${class?cap_first}Action {

    constructor() {
        this.generateActions('showEditModal', 'editRow', 'isLoading')
    }

    loading(isLoding) {
        return isLoding;
    }

    pageChange(pageNo) {
        let {${class}, filter} =${class?cap_first}Store.getState();

        this.fetchData({
            pageNo: pageNo,
            pageSize: ${class}.get('pageSize')
        }, filter.toJS());

        return pageNo;
    }

    deleteRow(id) {
        let _self = this;
        let {${class}} = ${class?cap_first}Store.getState();

        return function (dispatch) {
            return RestAPI.request(`/api/manager/admin/${r"${Config.getUserInfo() == null?'*':Config.getUserInfo().username}"}/${tableName?replace("_","-")}/${r"${id}"}/item`, {},
                'delete',
                true
            ).then((data) => {
                message.success('删除成功！');
                _self.fetchData({
                    pageNo: ${class}.get('pageNo'),
                    pageSize: ${class}.get('pageSize')
                },${class?cap_first}Store.getState().filter.toJS());
            }).catch(error => {
                message.error('删除失败！' + error.message);
            });
        }

    }

    add(<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>) {
        var _self = this;
        let {${class}} = ${class?cap_first}Store.getState();
        return function (dispatch) {
            return RestAPI.request(`/api/manager/admin/${r"${Config.getUserInfo() == null?'*':Config.getUserInfo().username}"}/${tableName?replace("_","-")}/item`,
                {
<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>
                },
                'POST',
                true
            ).then((data) => {
                message.success('添加成功！');
                _self.showEditModal(false);
                _self.fetchData({
                    pageNo: ${class}.get('pageNo'),
                    pageSize: ${class}.get('pageSize')
                },${class?cap_first}Store.getState().filter.toJS());
            }).catch(error => {
                message.error("添加失败");
            });
        }
    }

    update(edit${class?cap_first}DataId,<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>) {
        var _self = this;
        let {${class}} = ${class?cap_first}Store.getState();
        return function (dispatch) {
            return RestAPI.request(`/api/manager/admin/${r"${Config.getUserInfo() == null?'*':Config.getUserInfo().username}"}/${tableName?replace("_","-")}/${r"${id}"}/item`,
                {
                    <#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>
                },
                'POST',
                true
            ).then((data) => {
                message.success('修改成功！');
                _self.showEditModal(false);
                _self.fetchData({
                    pageNo: ${class}.get('pageNo'),
                    pageSize: ${class}.get('pageSize')
                },${class?cap_first}Store.getState().filter.toJS());
            }).catch(error => {
                message.error('修改失败！' + error.message);
            });

        }

    }

    filterChange(<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange) {
        let pageNo = 1;
        this.fetchData({
            pageNo,
            pageSize: ${class?cap_first}Store.getState().${class}.get('pageSize')
        }, {
            <#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange
        });
        return {
            <#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange
        };
    }

    fetchData({pageNo, pageSize}, {<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange}) {
        let _self = this;
        dateRange = map(date => date.format('YYYY-MM-DD'))(dateRange);
        return function (dispatch) {
            _self.loading(true);
            return RestAPI.request(`/api/manager/admin/${r"${Config.getUserInfo() == null?'*':Config.getUserInfo().username}"}/${tableName?replace("_","-")}/list`, {
                <#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>
                startTime:dateRange[0] == undefined ? '' : dateRange[0],
                endTime:dateRange[1] == undefined ? '' : dateRange[1],
                pageNo,
                pageSize},'get',true)
                .then((res) => {
                    _self.loading(false);
                    let data = {
                    ${class}: res.${class},
                        total: res.total,
                    };
                    dispatch(data);

                }).catch(error => {
                    _self.loading(false);
                    message.error(error.message);
                });
        }
    }

}


export default alt.createActions(${class?cap_first}Action);
