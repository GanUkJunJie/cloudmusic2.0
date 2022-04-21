const rank = {
    path: 'rank',
    name: 'rank',
    component: () => import('@/views/discover-music/rank'),
    meta: {
        title: '排行榜',
        permission: true,
        name:'rank',
        activeMenu:'/discoverMusic',
    },
    children: []
}

export default rank