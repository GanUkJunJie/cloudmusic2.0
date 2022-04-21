import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//轮播图
export function carousel(data){
    return postRequest('/banner', data, showErrMsg)
}

//推荐歌单
export function musicList(data){
    return postRequest('/personalized', data, showErrMsg)
}