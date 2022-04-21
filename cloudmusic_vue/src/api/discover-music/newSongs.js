import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//新歌速递
export function newSong(data){
    return postRequest('/top/song', data, showErrMsg)
}

//新碟上架
export function album(data){
    return postRequest('/top/album', data, showErrMsg)
}