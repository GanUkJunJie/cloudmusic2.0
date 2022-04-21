import Layout from '@/layout';

const podcastConfig = {
    path: '/podcast',
    component: Layout,
    name: 'podcast',
    meta: {
        title: '播客',
        isMenu: true,
        MenuIndex: 2,
        activeMenu:'/podcast',
    },
    alwaysShow: true,
    children: []
}

export default podcastConfig