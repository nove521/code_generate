import alt from 'app/alt';
import {Map,List} from 'immutable';
import ${class?cap_first}Action from 'actions/${class?cap_first}Action';
import moment from 'moment';

class ${class?cap_first}Store{
    constructor() {
        this.state = this._getInitialState();
        this.bindActions(${class?cap_first}Action);
    }

    _getInitialState(){
        return{
            ${class}:Map({
                loading:false,
                data:List(),
                total:0,
                pageNo:1,
                pageSize:10
            }),
            filter:Map({
                <#list tableKey as key>${tableKeyNameFormat[key_index]}:'',</#list>
                dateRange:List([moment().subtract(1, 'M'), moment()]),//moment数组对象
            }),
            editModal: {
                show: false
            },
            edit${class?cap_first}Data: null
        }
    }

    onLoading(isLoding){
        this.setState(({${class}})=>({
            ${class}: ${class}.update('loading',v=>isLoding)}));
    }

    onAllPurchases(purchases){

        this.setState({
            purchases:purchases
        })
    }

     showEditModal(show){
            this.setState({
                editModal: {
                    show: show
                },
                edit${class?cap_first}Data: null
            })
        }


    onFilterChange({<#list tableKey as key>${tableKeyNameFormat[key_index]},</#list>dateRange}){

        this.setState(({filter})=>({
            filter:filter
            <#list tableKey as key>
                .set('${tableKeyNameFormat[key_index]}',${tableKeyNameFormat[key_index]})
            </#list>
                .set('dateRange',List(dateRange))
        }));
    }

    editRow(record){

        this.setState({
            editModal: {
                show: true
            },
            edit${class?cap_first}Data: record
        });
    }

    onPageChange(pageNo){

        this.setState(({${class}})=>({
            ${class}:${class}.set('pageNo',pageNo)}));
    }

    onFetchData({${class},total}){

        let data = ${class};
        this.setState(({${class}})=>({
        ${class}:${class}.set('loading',false)
                .set('data',List(data))
                .set('total',total)
        }));
    }
}

export default alt.createStore(${class?cap_first}Store);
