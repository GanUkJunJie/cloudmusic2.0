import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//获取榜单
export function rankList(){
    return postRequest('/toplist', {}, showErrMsg)
}
