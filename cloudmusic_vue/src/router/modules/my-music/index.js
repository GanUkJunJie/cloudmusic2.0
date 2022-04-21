import Layout from '@/layout';
import localAndDown from './localAndDown';
import recentlyPlayed from './recentlyPlayed';
import cloudDisk from './cloudDisk';
import myPodcast from './myPodcast';
import collection from './collection';

const myMusicConfig = {
    path: '/myMusic',
    component: Layout,
    name: 'myMusic',
    meta: {
        title: '我的音乐',
        isMenu: true,
        icon: 'myMusic',
        MenuIndex: 6,
        hasChildren: true, //二级菜单
        keepOpen: true, //永远展开菜单
    },
    // redirect: '/myMusic/personality',
    alwaysShow: true,
    children: [
        localAndDown,
        recentlyPlayed,
        cloudDisk,
        myPodcast,
        collection,
    ]
}

export default myMusicConfig