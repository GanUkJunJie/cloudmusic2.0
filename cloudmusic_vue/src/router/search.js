export const search = {
    name: 'search',
    path: 'search',
    component: () => import('@/components/search/index'),
    meta: {
        title: '搜索结果',
    },
    children: [
        {
            name: 'searchSongs',
            path: 'searchSongs',
            component: () => import('@/components/search/components/song'),
            meta: {
                title: '搜索歌曲',
            },
        },
        {
            name: 'searchArtists',
            path: 'searchArtists',
            component: () => import('@/components/search/components/artists'),
            meta: {
                title: '搜索歌手',
            },
        },
        {
            name: 'searchAlbums',
            path: 'searchAlbums',
            component: () => import('@/components/search/components/albums'),
            meta: {
                title: '搜索专辑',
            },
        },
        {
            name: 'searchPlaylist',
            path: 'searchPlaylist',
            component: () => import('@/components/search/components/playlist'),
            meta: {
                title: '搜索歌单',
            },
        },
    ]
}

export default search