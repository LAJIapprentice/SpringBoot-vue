<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 480px">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="书名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="学徒"
                    width="120">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="120">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                page-size="6"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            deleteBook(row) {
                const _this = this
                axios.delete("http://localhost:8081/book/deleteById/" + row.id).then(function (resp) {
                    _this.$alert('《' + row.name + `》删除成功`, '消息', {
                        confirmButtonText: '确定',
                        callback: action => {
                            //_this.$router.push(`/BookManage`)
                            window.location.reload()
                        }
                    });
                })
            },

            edit(row) {
                //row.id
                //this.$router.push(`/Update`)
                this.$router.push({
                    path: `/Update`,
                    //传入id,回显数据
                    query: {
                        id:row.id
                    }
                })

            },

            page(currentPage) {
                const _this = this
                axios.get(`http://localhost:8081/book/findAll/`+currentPage+`/6`).then(function (resp) {
                    _this.tableData = resp.data.content
                    _this.total = resp.data.totalElements
                })
            }
        },

        created() {
            const _this = this
            axios.get(`http://localhost:8081/book/findAll/1/6`).then(function (resp) {
                _this.tableData = resp.data.content
                _this.total = resp.data.totalElements
            })
        },

        data() {
            return {
                total: null ,
                tableData: null
            }
        }
    }
</script>