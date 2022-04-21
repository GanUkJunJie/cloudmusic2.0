const state = {
    playing: false,
    currentTime: 0,
    playSong:{
        playIdNow:'',
        playIdArr:[],
    },
    drawer: false,
}

const mutations = {
    IS_PLAYING: (state, playing) => {
        state.playing = playing
    },
    SET_CURRENT_TIME: (state, currentTime) => {
        state.currentTime = currentTime
    },
    SET_PLAY_SONG_ID: (state, play) => {
        state.playSong = {
            playIdNow: play.playIdNow,
            playIdArr: play.playIdArr
        }
    },
    SHOW_DRAWER: (state, drawer) => {
        state.drawer = drawer
    },
};

const actions = {
    isPlaying({ commit }, playing) {
        commit('IS_PLAYING',playing);
    },
    setCurrentTime({ commit }, currentTime) {
        commit('SET_CURRENT_TIME',currentTime);
    },
    setPlaySongId({ commit }, play) {
        commit('SET_PLAY_SONG_ID',play);
    },
    showDrawer({ commit }, drawer) {
        commit('SHOW_DRAWER',drawer);
    },
}

export default {
    namespaced: true,
    state,
    mutations,
    actions,
}