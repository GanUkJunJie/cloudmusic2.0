import createRouterMap from '@/router/generate-routes';
const state = {
    user: {
        id: 1,
        name: '未来',
        avatar: '../../assets/img/user.jpg'
    },
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
        routerList = createRouterMap([])
        commit('SET_MENU',routerList)
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions,
}