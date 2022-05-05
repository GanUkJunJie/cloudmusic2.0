import createRouterMap from '@/router/generate-routes';
import { userBase } from '@/api/service';
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
        const uuid =  window.sessionStorage.getItem("uuid")
        if (uuid) {
            userBase({
                uuid: uuid
            }).then(res => {
                commit('SET_USER',res.result)
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