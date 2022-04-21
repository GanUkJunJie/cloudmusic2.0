import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//歌手
export function artists(data){
    return postRequest('/artist/list', data, showErrMsg)
}

//歌手详情
export function artistDetail(data){
    return postRequest('/artist/detail', data, showErrMsg)
}

//热门50首歌
export function topFifty(data){
    return postRequest('/artist/top/song', data, showErrMsg)
}

//歌手介绍
export function introduce(data){
    return postRequest('/artist/desc', data, showErrMsg)
}

//相似歌手
export function similar(data){
    return postRequest('/simi/artist', data, showErrMsg)
}

