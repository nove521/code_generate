import React, {Component} from 'react';
import ${class?cap_first}Filter from './filter'
import {Table,Card,Button,Tooltip,Popconfirm} from 'antd';
import {map} from 'lodash/fp';
import ${class?cap_first}AddModal from './modal';
import ${class?cap_first}Store from 'store/${class?cap_first}Store';
import ${class?cap_first}Action from 'actions/${class?cap_first}Action';
import {connect} from 'alt-react';

class ${class?cap_first} extends Component {

    constructor(props) {
        super(props);
        this.state = {
        }
    }

    //翻页触发
    pageChange = (page, pageSize) => {
        let {current} = page;
        ${class?cap_first}Action.pageChange(current)
    };

    showEditModal = (show) => {
        ${class?cap_first}Action.showEditModal(show);
    }

    editRow = (index, record) => {
        ${class?cap_first}Action.editRow(record)
    }

    deleteRow = (id) => {
        ${class?cap_first}Action.deleteRow(id);
    }

     handleAddSubmit = (<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange) => {
        ${class?cap_first}Action.add(<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange);
    }

    handleEditSubmit = (edit${class?cap_first}DataId,<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>) => {
        ${class?cap_first}Action.update(edit${class?cap_first}DataId,<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>);
    }

    render() {
        let _self = this;
        let {${class}, filter,editModal, edit${class?cap_first}Data} = this.props;
        return (
            <div >
                <Card title="日志" style={{marginBottom: 30}}>
                    <${class?cap_first}Filter dataSource={{filter}} onCommit={${class?cap_first}Action.filterChange} onAddCard={this.showEditModal} />
                </Card>
                <Card title="列表">
                    <Table dataSource={${class}.get('data').toArray()} onChange={this.pageChange}
                           bordered
                           columns={[
                           <#list tableKey as key>
                               {
                                    title: '${key.annotation}',
                                    dataIndex: '${tableKeyNameFormat[key_index]}',
                                    key: '${tableKeyNameFormat[key_index]}',
                                    align:'left'
                                },
                           </#list>
                                {
                                    title: '操作',
                                    key: 'operator',
                                    render: (text, record, index) => {
                                    return (
                                        <div>
                                            <Button style={{backgroundColor: '#00a854', color: '#fff'}}
                                            onClick={() => this.editRow(index, record)}>编辑</Button >
                                            <span className="ant-divider"/>
                                            <Popconfirm title={`确定要删吗?`}
                                                        onConfirm={() => this.deleteRow(record.id)}
                                                        okText="确认" cancelText="取消">
                                                <Button type="danger">删除</Button>
                                            </Popconfirm>

                                        </div>
                                        )
                                    }
                                }
                            ]}
                    pagination={{
                        total: ${class}.get('total'),
                        current: ${class}.get('pageNo'),
                        pageSize: ${class}.get('pageSize')
                    }} rowKey="id" loading={${class}.get('loading')}/>
                    <Tooltip>
                        <span>总计{${class}.get('total')}条数据，每页显示{${class}.get('pageSize')}条，共{Math.ceil(${class}.get('total') / ${class}.get('pageSize'))}页，当前第{${class}.get('pageNo')}页</span>
                    </Tooltip>
                </Card>
                {editModal.show ? <${class?cap_first}AddModal show={editModal.show} onCloseModal={()=>this.showEditModal(false)}
                    onSubmit={this.handleAddSubmit} onEditSubmit={this.handleEditSubmit}
                    edit${class?cap_first}Data={edit${class?cap_first}Data}/> : null}
            </div>
        )
    }

    componentDidMount() {
        let {${class}, filter} = this.props;
        ${class?cap_first}Action.fetchData({
            pageNo: ${class}.get('pageNo'),
            pageSize: ${class}.get('pageSize')
        }, filter.toJS());
    }

}

export default connect(${class?cap_first}, {
    listenTo() {
        return [${class?cap_first}Store];
    },
    getProps() {
        return {
            ${class}: ${class?cap_first}Store.getState().${class},
            filter: ${class?cap_first}Store.getState().filter,
            editModal: ${class?cap_first}Store.getState().editModal,
            edit${class?cap_first}Data:${class?cap_first}Store.getState().edit${class?cap_first}Data
        }
    }
});
