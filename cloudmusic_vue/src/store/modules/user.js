import createRouterMap from '@/router/generate-routes';
import { queryMenu, userBase } from '@/api/service';
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
    async getInfo({ commit, state}) {
        const uuid =  window.sessionStorage.getItem("uuid")
        if (uuid) {
            userBase({
                uuid: uuid
            }).then(res => {
                commit('SET_USER',res.result)
            })
        }
        let routerList = (await queryMenu({uuid: uuid})).result
        routerList = createRouterMap(routerList)
        commit('SET_MENU',routerList)
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions,
}