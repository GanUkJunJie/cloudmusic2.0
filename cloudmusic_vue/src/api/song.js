import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//音乐详情
export function songDetail(data){
    return postRequest('/song/detail', data, showErrMsg)
}

//音乐url
export function songUrl(data){
    return postRequest('/song/url', data, showErrMsg)
}

//歌词
export function songLyrics(data){
    return postRequest('/lyric', data, showErrMsg)
}