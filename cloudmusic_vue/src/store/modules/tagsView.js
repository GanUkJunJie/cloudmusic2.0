const state = {
    visitedViews: [],
    cachedViews: [],
    exclude: [],
}

const mutations = {
    ADD_VISITED_VIEW: (state, view) => {
        // console.log(view);
        state.visitedViews = [];
        if (view.meta.inside && view.children && view.children.length !== 0) {
            view.children.array.forEach(item => {
                state.cachedViews.push(item)
            });
        }
    },
    ADD_CACHED_VIEW: (state, view) => {
        // console.log(view);
        state.cachedViews = [];
        if (view.meta.inside && view.children && view.children.length !== 0) {
            view.children.array.forEach(item => {
                state.cachedViews.push(item.name)
            });
        }
    }
};

const actions = {
    addTagsView({dispatch},view) {
        dispatch('addVisitedViews',view)
        dispatch('addCachedViews',view)
    },
    addVisitedViews({ commit }, view) {
        commit('ADD_VISITED_VIEW',view);
    },
    addCachedViews({ commit }, view) {
        commit('ADD_CACHED_VIEW',view);
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions,
}