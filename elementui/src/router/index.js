import Vue from 'vue'
import VueRouter from 'vue-router'
import BookManage from "../views/BookManage";
import AddBook from "../views/AddBook";
import Update from "../views/Update";
import PageFour from "../views/PageFour";
import Index from "../views/Index";

Vue.use(VueRouter)

  const routes = [
  {
    path: "/",
    name: "图书管理",
    component:Index,
    show: true,
    redirect: "/BookManage",
    children: [
      {
        path: "/BookManage",
        name: "查询图书",
        component:BookManage
      },
      {
        path: "/AddBook",
        name: "添加图书",
        component:AddBook
      }
    ]
  },
  {
    path: "/Update",
    name: "页面3",
    component:Update,
    show: false
  },
  // {
  //   path: "/navigation",
  //   name: "导航二",
  //   component: Index,
  //   children: [
  //     {
  //       path: "/Update",
  //       name: "页面3",
  //       component:Update
  //     },
  //     {
  //       path: "/pageFour",
  //       name: "页面4",
  //       component:PageFour
  //     }
  //   ]
  // }

]

const router = new VueRouter({
  routes
})

export default router
