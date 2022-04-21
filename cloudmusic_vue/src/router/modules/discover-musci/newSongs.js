const newSongs = {
    path: 'newSongs',
    name: 'newSongs',
    component: () => import('@/views/discover-music/newSongs'),
    meta: {
        title: '最新音乐',
        permission: true,
        name:'newSongs',
        activeMenu:'/discoverMusic',
    },
    children: []
}

export default newSongs