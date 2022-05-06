import routerFun from './router-map';

function sortRouterMap(router,data){
    const currentRouter = []
    if (!router || !data) return currentRouter
    data.map(dataItem => {
        router.some(routerItem => {
            if (routerItem.path === dataItem.menuCode) {
                if (!routerItem.meta.navInside) {
                    // 千万不要修改 routerItem 会覆盖 routerMap 导致无法监听正确数据变化
                    // const item = JSON.parse(JSON.stringify(routerItem))
                    routerItem.children = sortRouterMap(routerItem.children,dataItem.subMenu)
                    // return currentRouter.push(item)
                }
                return currentRouter.push(routerItem)
            }
        })
    })
    return currentRouter
}
function createRouterMap(data) {
    let routerMap = routerFun();
    return sortRouterMap(routerMap,data)
}

export default createRouterMap