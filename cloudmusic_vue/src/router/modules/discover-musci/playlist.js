const playlist = {
    path: 'playlist',
    name: 'playlist',
    component: () => import('@/views/discover-music/playlist'),
    meta: {
        title: '歌单',
        permission: true,
        name:'playlist',
        activeMenu:'/discoverMusic',
    },
    children: []
}

export default playlist