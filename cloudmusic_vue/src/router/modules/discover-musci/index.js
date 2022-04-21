import Layout from '@/layout';
import Index from '@/views/discover-music';
import personality from './personality';
import custom from './custom';
import playlist from './playlist';
import rank from './rank';
import singer from './singer';
import newSongs from './newSongs';

const discoverMusicConfig = {
    path: '/discoverMusic',
    component: Layout,
    meta: {
        title: '发现音乐',
        isMenu: true,
        MenuIndex: 0,
        navInside: true,
    },
    alwaysShow: true,
    children: [
        {
            path: '/',
            component: Index,
            redirect: '/discoverMusic/personality',
            children: [
                personality,
                custom,
                playlist,
                rank,
                singer,
                newSongs,
            ]
        }
    ]
}

export default discoverMusicConfig