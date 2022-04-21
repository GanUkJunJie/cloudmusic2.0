import Layout from '@/layout';

const liveConfig = {
    path: '/live',
    component: Layout,
    name: 'live',
    meta: {
        title: '直播',
        isMenu: true,
        MenuIndex: 4,
        activeMenu:'/live',
    },
    alwaysShow: true,
    children: []
}

export default liveConfig