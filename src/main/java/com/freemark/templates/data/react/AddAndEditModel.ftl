import React, {Component, PropTypes} from 'react';
import {Form, Icon, Input, Button, Checkbox, Modal, Select, DatePicker, Upload, Cascader, message} from 'antd';

const FormItem = Form.Item;
const formItemLayout = {
    labelCol: {
        xs: {span: 24},
        sm: {span: 6},
    },
    wrapperCol: {
        xs: {span: 24},
        sm: {span: 14},
    },
};

const formItemClass = {
    margin: 0
}

const tailFormItemLayout = {
    wrapperCol: {
        xs: {
            span: 24,
            offset: 0,
        },
        sm: {
            span: 14,
            offset: 6,
        },
    },
};

class ${class}AddModal extends Component {

    constructor(props) {
        super(props);
        this.state = {
        }

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        let _self = this;
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                const {imgUrlList} = this.state;
                let {onSubmit, onEditSubmit, edit${class?cap_first}Data} = this.props;
                let {<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>} = values;
                if (edit${class?cap_first}Data) {
                    onEditSubmit && onEditSubmit(edit${class?cap_first}Data.id,<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>);
                }
                else {
                    onSubmit && onSubmit(<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>);
                }
            }
        });
    }

    render() {
        const {getFieldDecorator} = this.props.form;
        let {onCloseModal, show, edit${class?cap_first}Data} = this.props;
        const {previewVisible, previewImage, fileList} = this.state;
        const opeartion = edit${class?cap_first}Data ? '修改' : '添加';
        const btnValue = edit${class?cap_first}Data ? '保存' : '添加';
        <#list tableKey as key>
        let ${tableKeyNameFormat[key_index]}
        </#list>
        if (edit${class?cap_first}Data) {
        <#list tableKey as key>
            ${tableKeyNameFormat[key_index]} = edit${class?cap_first}Data.${tableKeyNameFormat[key_index]}
        </#list>
        }
        return (
            <Modal width={800} title={opeartion} visible={show} onCancel={onCloseModal} footer={[]}>
                <Form onSubmit={this.handleSubmit}>
                    <#list tableKey as key>
                        <FormItem style={formItemClass} {...formItemLayout} label='${key.annotation}'>
                            {getFieldDecorator('${tableKeyNameFormat[key_index]}', {
                                initialValue: ${tableKeyNameFormat[key_index]}
                            })(
                                <Input/>
                            )}
                        </FormItem>
                    </#list>
                    <FormItem style={formItemClass} {...tailFormItemLayout}>
                        <Button type="primary" htmlType="submit">{btnValue}</Button>
                    </FormItem>
                </Form>
            </Modal>
        );
    }
}


const Wrapped${class}AddModal = Form.create()(${class}AddModal);

export default Wrapped${class}AddModal;
