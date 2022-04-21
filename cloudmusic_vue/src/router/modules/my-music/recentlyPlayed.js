const recentlyPlayed = {
    path: 'recentlyPlayed',
    name: 'recentlyPlayed',
    // component: () => ('views/discover/children/Personality'),
    meta: {
        title: '最近播放',
        isMenu: true,
        icon: 'icon-record',
        permission: true,
        name:'recentlyPlayed',
        activeMenu:'/myMusic/recentlyPlayed',
    },
    children: []
}

export default recentlyPlayed