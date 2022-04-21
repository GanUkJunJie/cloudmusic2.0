import Layout from '@/layout';
const collectionPlaylistConfig = {
    path: '/collectionPlaylist',
    component: Layout,
    name: 'collectionPlaylist',
    meta: {
        title: '收藏的歌单',
        isMenu: true,
        icon: 'collectionPlaylist',
        MenuIndex: 8,
        hasChildren: true, //二级菜单
    },
    alwaysShow: true,
    children: [

    ]
}

export default collectionPlaylistConfig