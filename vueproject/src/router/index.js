import Vue from 'vue'
import VueRouter from 'vue-router'
import PageOne from '../views/PageOne'
import PageTwo from '../views/PageTwo'
import PageThree from '../views/PageThree'
import Index from '../views/Index'

Vue.use(VueRouter);
const routes = [
    {
        path: '/',
        name: '图书管理',
        component: Index,
        show: true,
        redirect: "/PageOne",
        children: [
            {
                path: '/PageOne',
                name: '查询图书',
                component: PageOne
            },
            {
                path: '/PageTwo',
                name: '添加图书',
                component: PageTwo
            },
        ]
    },
    {
        path: '/update',
        component: PageThree,
        show: false
    }
    // ,
    // {
    //     path: '/navigation',
    //     name: '导航2',
    //     component: Index,
    //     children:[
    //         {
    //             path: '/PageThree',
    //             name:'页面3',
    //             component: PageThree
    //         },
    //         {
    //             path: '/PageFour',
    //             name:'页面4',
    //             component: PageFour
    //         },
    //     ]
    // }
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router
