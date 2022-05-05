const name = '网易云音乐网'

const path = require('path')
function resolve(dir) {
    return path.join(__dirname, dir)
}
module.exports = {
    publicPath:'/',
    lintOnSave: false, //关闭语法检查
    devServer: {
        proxy: {
            '/api': {
                target: 'https://autumnfish.cn/',
                pathRewrite: {
                    '^/api': ''
                },
                changeOrigin: true,
                ws: true,
            },
            '/service': {
                target: 'http://localhost:8081/',
                pathRewrite: {
                    '^/service': ''
                },
                changeOrigin: true,
                ws: true,
            },
        }
    },
    configureWebpack: {
        name: name,
        resolve: {
            alias: {
                '@':resolve('src'),
            }
        },
    },
    
}