import routerFun from './router-map';
function sortRouterMap(router,data){
    const currentRouter = []
    if (!router || !data) return currentRouter
    data.map(dataItem => {
        router.some(routerItem => {
            if (routerItem.path === dataItem.menuCode) {
                return currentRouter.push(routerItem)
            }
        })
    })
    return currentRouter
}

function createRouterMap(data,create) {
    let routerMap = routerFun()
    let currentRouter = sortRouterMap(routerMap,data)
    if (window.sessionStorage.getItem("uuid")) {
        addCreate(currentRouter,create)
    }
    return currentRouter
}

function addCreate(routerMap,create){
    let index = create.findIndex((item) => item.subscribed == true);
    let createdMusicList = create.slice(0, index);
    createdMusicList[0].name = "我喜欢的音乐";
    let collectedMusicList = create.slice(index);
    routerMap.map(routerItem => {
        if (routerItem.path === '/createPlaylist') {
            routerItem.children = [...routerItem.children,...createPlaylist(createdMusicList)]
        } else if (routerItem.path === '/collectionPlaylist') {
            routerItem.children = createPlaylist(collectedMusicList)
        }
    })
}

function createPlaylist(list){
    let children = []
    list.map(item => {
        children.push({
            path: '/playlistDetail/id=' + item.id,
            component: () => import('@/components/playlist/index'),
            name: '/playlistDetail/id=' + item.id,
            meta: {
                title: item.name,
                isMenu: true,
                icon:'icon-musiclist',
                permission: true,
                name:'/playlistDetail/id=' + item.id,
                activeMenu:'/createPlaylist/playlistDetail/id=' + item.id,
            },
            props:{
                id: item.id,
            }
        })
    })
    return children
}

export default createRouterMap