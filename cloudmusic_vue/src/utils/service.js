import axios from 'axios';
import { Message } from 'element-ui';


const service = axios.create({
    baseURL: '/service',
    withCredentials: true,
    crossDomain: true,
    timeout: 60000,
    headers: {}
})

service.interceptors.request.use(
    config => ({
        ...config,
    }),
    error => {
        console.log(error);
        return Promise.reject(error)
    }
)

service.interceptors.response.use(
    response => {
        const res = response.data
        if (res.code === 401 ) {
            Message({
                message: '服务超时，请重新登录系统',
                type: 'error',
                duration: 5 * 1000
            })
        }
        return res
    },
    error => {
        return Promise.reject(error)
    }
)

export const postService = (url, data, {showErrMsg = false} = {}) => {
    return service({
        url: url,
        method: 'get',
        params: data,
    }).then(res => {
        if (res.code == '200') {
            // sessionData(url, data, res)
            return res
        } else {
            if (showErrMsg) {
                Message({
                    message: res.message || '出错啦，请稍后再试！',
                    type: 'error'
                })
            }
            console.log(`error api: ${url}`);
            throw res
        }
    })
}

export default service