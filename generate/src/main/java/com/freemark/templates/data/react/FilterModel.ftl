import React, {Component} from "react";
import {Form, Input, Button, DatePicker, Select,} from "antd";
import {trim} from "app/utils";
const {RangePicker} = DatePicker;
import {map} from 'lodash/fp';


const dateFormat = 'YYYY/MM/DD';
const FormItem = Form.Item;

class ${class?cap_first}Filter extends Component {

    constructor(props) {
        super(props);

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        let _self = this;
        this.props.form.validateFields((err, values) => {
            if (!err) {
                let {onCommit} = _self.props;
                let {<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange} = values;
                onCommit && onCommit(<#list tableKey as key><#if key.type == 'String'>trim(${tableKeyNameFormat[key_index]})<#else>${tableKeyNameFormat[key_index]}</#if>,</#list>dateRange);
            }
        });
    }


    render() {
        const {getFieldDecorator} = this.props.form;
        const {dataSource,onAddCard} = this.props;
        const {<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange} = dataSource.filter.toJS();
        return (
            <Form onSubmit={this.handleSubmit} layout="inline">
                <#list tableKey as key>
                 <FormItem label="${key.annotation}">
                    {getFieldDecorator('${tableKeyNameFormat[key_index]}', {
                        initialValue: ${tableKeyNameFormat[key_index]}
                    }
                    )(
                        <Input style={{width: '150px'}} placeholder="请输入${key.annotation}"/>
                    )}
                  </FormItem>
                </#list>
                <FormItem label="创建时间区间：">
                    {getFieldDecorator('dateRange', {
                        initialValue: dateRange
                        })(<RangePicker format={dateFormat} />
                    )}
                </FormItem>
                <FormItem>
                    <Button type="primary" htmlType="submit" style={{width: '100%'}}>
                        查询
                    </Button>
                </FormItem>
                <FormItem>
                    <Button type="primary" onClick={ () => {
                        onAddCard && onAddCard(true);
                        } }>
                        添加
                    </Button>
                </FormItem>
            </Form>
        );
    }
}

const Filter = Form.create()(${class?cap_first}Filter);

export default Filter;
