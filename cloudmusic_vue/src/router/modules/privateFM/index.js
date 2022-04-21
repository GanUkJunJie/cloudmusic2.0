import Layout from '@/layout';

const privateFMConfig = {
    path: '/privateFM',
    component: Layout,
    name: 'privateFM',
    meta: {
        title: '私人FM',
        isMenu: true,
        MenuIndex: 5,
        activeMenu:'/privateFM',
    },
    alwaysShow: true,
    children: []
}

export default privateFMConfig