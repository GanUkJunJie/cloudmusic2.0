const custom = {
    path: 'custom',
    name: 'custom',
    component: () => import('@/views/discover-music/custom'),
    meta: {
        title: '专属定制',
        permission: true,
        name:'custom',
        activeMenu:'/discoverMusic',
    },
    children: []
}

export default custom