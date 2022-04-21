import routerFun from './router-map';

var routerMap = routerFun();

function sortRouterMap(){
    routerMap.sort((a,b) => {
        return a.meta.MenuIndex-b.meta.MenuIndex;
    })
}
function createRouterMap(data) {
    sortRouterMap()
    return routerMap
}

export default createRouterMap