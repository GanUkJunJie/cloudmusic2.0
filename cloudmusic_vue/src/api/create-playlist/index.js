import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//获取我的歌单
export function createList(){
    return postRequest('/user/playlist?uid=262431036', {}, showErrMsg)
}
