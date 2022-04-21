import Layout from '@/layout';
import loveList from './loveList';
const createPlaylistConfig = {
    path: '/createPlaylist',
    component: Layout,
    name: 'createPlaylist',
    meta: {
        title: '创建的歌单',
        isMenu: true,
        icon: 'createPlaylist',
        MenuIndex: 7,
        hasChildren: true, //二级菜单
    },
    alwaysShow: true,
    children: [
        loveList,
    ]
}

export default createPlaylistConfig