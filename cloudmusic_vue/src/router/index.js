import Vue from 'vue';
import Router from 'vue-router';
import Layout from '@/layout';
import store from '../store';
import search from './search';

const originalPush = Router.prototype.push;
Router.prototype.push = function push(location, onResolve, onReject) {
    if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
    return originalPush.call(this, location).catch(err => err)
};
Vue.use(Router) 

export const constantRoutes = [
    {
        path: '/',
        component: Layout,
        redirect: '/discoverMusic', 
        meta: {
            title: '首页',
        },
        children: [
            search,
            {
                name: 'playlistDetail',
                path: 'playlistDetail',
                component: () => import('@/components/playlist/index'),
                meta: {
                    title: '歌单详情',
                },
                props(route){
                    return {
                        id: route.query.id
                    }
                }
            },
            {
                name: 'artistDetail',
                path: 'artistDetail',
                component: () => import('@/components/artist/index'),
                meta: {
                    title: '歌手详情',
                },
            },
            {
                name: 'userInfo',
                path: 'userInfo',
                component: () => import('@/views/user/userInfo'),
                meta: {
                    title: '个人信息',
                },
            },
            {
                name: 'editUserInfo',
                path: 'editUserInfo',
                component: () => import('@/views/user/editUserInfo'),
                meta: {
                    title: '用户个人编辑',
                },
            },
        ],
    },
    {
        path: '*',
        beforeEnter: async function(to, from, next) {
            //此处可做路由拦截
            if (store.getters.menu && !store.getters.menu.length) {
                await store.dispatch('user/getInfo')
                router.addRoutes(store.getters.menu)
            }
            
            next();
        }
    }
]

const createRouter = () => {
    const router = new Router({
        scrollBehavior: () => ({ y: 0}),
        routes: constantRoutes,
    })
    return router
}

const router = createRouter()

export default router