import createRouterMap from '@/router/generate-routes';
const state = {
    user: {
        id: null,
        name: null,
        avatar: null,
        tel: null,
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
        const user =  window.sessionStorage.getItem("tel")
        console.log(user);
        if (user) {
            commit('SET_USER',{
                id: 1,
                name: '未来',
                avatar: null,
                tel: user,
            })
        }
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