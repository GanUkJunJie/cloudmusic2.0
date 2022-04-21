import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//音乐评论
export function songComments(data){
    return postRequest('/comment/music', data, showErrMsg)
}

//热门评论 0: 歌曲 1: mv 2: 歌单 3: 专辑 4: 电台 5: 视频
export function hotComments(data){
    return postRequest('/comment/hot', data, showErrMsg)
}