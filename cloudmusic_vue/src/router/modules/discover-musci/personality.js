const personality = {
    path: 'personality',
    name: 'personality',
    component: () => import('@/views/discover-music/personality'),
    meta: {
        title: '个性推荐',
        permission: true,
        name:'personality',
        activeMenu:'/discoverMusic',
    },
    children: []
}

export default personality