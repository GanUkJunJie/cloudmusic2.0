import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//歌单详情
export function playlistDetail(data){
    return postRequest('/playlist/detail', data, showErrMsg)
}

//精品歌单
export function hightQuality(data){
    return postRequest('/top/playlist/highquality', data, showErrMsg)
}

//获取热门标签
export function hotTags(){
    return postRequest('playlist/hot', {}, showErrMsg)
}

//获取标签
export function tags(){
    return postRequest('playlist/catlist', {}, showErrMsg)
}

//获取标签歌单
export function hotPlaylist(data){
    return postRequest('top/playlist', data, showErrMsg)
}
