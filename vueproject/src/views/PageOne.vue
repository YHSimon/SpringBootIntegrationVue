<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    weight="1">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="书名"
                    weight="1">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    weight="1">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    weight="1">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="size"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "PageOne",
        methods:{
            page(currentPage){
                const _this=this;
                axios.get('http://localhost:8888/book/findAll/'+(currentPage-1)+'/6').then(function (resp) {
                    _this.tableData=resp.data.content;
                    _this.size=resp.data.size;
                    _this.total=resp.data.totalElements;
                })
            },
            edit(row){
                this.$router.push({
                    path:'/update',
                    query:{
                        id: row.id
                    }
                })
            },
            deleteBook(row){
                const _this=this;
                axios.delete('http://localhost:8888/book/deleteById/'+row.id).then(function (resp) {
                    _this.$alert('《'+row.name+'》删除成功！', '消息', {
                        confirmButtonText: '确定',
                        callback: action => {
                            window.location.reload()
                        }
                    })
                })
            }
        },

        data(){
            return{
                size: 0,
                total: 0,
                tableData:[]
            }
        },
        created() {
            const _this=this;
            axios.get("http://localhost:8888/book/findAll/0/6").then(function (resp) {
                // console.log(resp);
                _this.tableData=resp.data.content;
                _this.size=resp.data.size;
                _this.total=resp.data.totalElements;
            })
        }
    }
</script>

<style scoped>

</style>