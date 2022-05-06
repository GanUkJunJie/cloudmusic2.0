const loveList = {
    path: 'loveList',
    name: 'loveList',
    component: () => import('@/views/create-playlist/loveList'),
    meta: {
        title: '我喜欢的音乐',
        isMenu: true,
        icon:'icon-love',
        permission: true,
        name:'loveList',
        activeMenu:'/createPlaylist/loveList',
    },
    children: []
}

export default loveList