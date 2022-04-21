const singer = {
    path: 'singer',
    name: 'singer',
    component: () => import('@/views/discover-music/singer'),
    meta: {
        title: '歌手',
        permission: true,
        name:'singer',
        activeMenu:'/discoverMusic',
    },
    children: []
}

export default singer