import createRouterMap from '@/router/generate-routes';
// import { getInfo } from '@/api/user';
const state = {
    user: {},
    menu: [],
}

const mutations = {
    SET_USER: (state,data) => {
        state.user = data;
    },
    SET_MENU: (state,data) => {
        state.menu = data;
    }
}

const actions = {
    getInfo({ commit, state}) {
        var routerList = []
        // return new Promise((resolve, reject) => {
            // 数据库读取路由
            // getInfo(state.token).then( res => {
            //     const { result } = res;
            //     routerList = createRouterMap((result && result.menuList) || [])

            routerList = createRouterMap([])
            commit('SET_MENU',routerList)
            commit('SET_USER', {
                id: 1,
                name: 'K',
                avatar: '../../assets/img/user.jpg'
            });
            // resolve(result);

            // }).catch (err => {
            //     reject(err)
            // })
        // })
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions,
}