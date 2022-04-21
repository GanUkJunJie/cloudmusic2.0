const getters = {
    menu: state => state.user.menu,
    user: state => state.user.user,
    playing: state => state.play.playing,
    currentTime: state => state.play.currentTime,
    playSong: state => state.play.playSong,
    drawer: state => state.play.drawer,
}
export default getters