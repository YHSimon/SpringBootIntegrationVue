<template>
    <div>
        <table>
            <tr>
                <td>编号</td>
                <td>书名</td>
                <td>作者</td>
            </tr>
            <tr v-for="book in books">
                <td>{{book.id}}</td>
                <td>{{book.name}}</td>
                <td>{{book.author}}</td>
            </tr>
        </table>
        {{msg}}
    </div>
</template>

<script>
    export default {
        name: "Book",
        data(){
            return{
                msg:'Hello Vue',
                books:[
                    {
                        id: 1 ,
                        name: 'Vue实战',
                        author:'张三',
                    },
                    {
                        id: 2 ,
                        name: 'SpringBoot实战',
                        author:'王五',
                    },
                    {
                        id: 3 ,
                        name: '整合实战',
                        author:'赵六',
                    }
                ]
            }
        },
        created() {
            const _this=this;
            axios.get("http://localhost:8888/book/findAll").then(function (resp) {
                // console.log(resp);
                _this.books=resp.data
            })
        }
    }
</script>

<style scoped>

</style>