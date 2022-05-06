export default function() {
    let routerMap = []
    const modulesFiles = require.context('./modules', true, /\index.js$/);
    modulesFiles.keys().reduce((modules, modulesPath) => {
        const moduleName = modulesPath.replace(/^\.\/(.*)\.\w+$/, '$1');
        const value = modulesFiles(modulesPath);
        modules[moduleName] = value.default;
        routerMap.push(value.default);
        return modules;
    },{})
    return routerMap;
}