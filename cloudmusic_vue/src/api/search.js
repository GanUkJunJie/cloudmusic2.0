import { postRequest } from '@/utils/request';

const showErrMsg = { showErrMsg: true }

//热搜列表
export function hotSearch(data){
    return postRequest('/search/hot/detail', {}, showErrMsg)
}

//搜索建议
export function searchSuggest(data){
    return postRequest('/search/suggest', data, showErrMsg)
}

//搜索结果
//type: 搜索类型；默认为 1 即单曲 , 取值意义 : 1: 单曲, 10: 专辑, 100: 歌手, 1000: 歌单, 1002: 
//用户, 1004: MV, 1006: 歌词, 1009: 电台, 1014: 视频, 1018:综合, 2000:声音(搜索声音返回字段格式会不一样)
export function cloudsearch(data){
    return postRequest('cloudsearch', data, showErrMsg)
}

//搜索多重匹配
export function multiMatchSearch(data){
    return postRequest('/search/multimatch', data, showErrMsg)
}
