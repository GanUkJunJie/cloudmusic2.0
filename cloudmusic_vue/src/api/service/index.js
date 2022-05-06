import { postService } from '@/utils/service';

const showErrMsg = { showErrMsg: true }

//菜单
export function queryMenu(data){
    return postService('/menu/getMenu', data, showErrMsg)
}

//注册
export function register(data){
    return postService('/user/register', data, showErrMsg)
}

//登录
export function login(data){
    return postService('/user/login', data, showErrMsg)
}

//用户基本信息
export function userBase(data){
    return postService('/userInfo/getUserBase', data, showErrMsg)
}

//用户动态信息
export function userDynamic(data){
    return postService('/userDynamic/getUserDynamic', data, showErrMsg)
}

//用户详细信息
export function userInfo(data){
    return postService('/userInfo/getUserInfo', data, showErrMsg)
}

//编辑详细信息
export function updateUserInfo(data){
    return postService('/userInfo/updateUserInfo', data, showErrMsg)
}

//获取我喜欢的音乐id
export function getLike(data){
    return postService('/like/getLike', data, showErrMsg)
}

//喜欢音乐
export function addLike(data){
    return postService('/like/addLike', data, showErrMsg)
}

//我喜欢的音乐Count
export function getCount(data){
    return postService('/loveList/getCount', data, showErrMsg)
}
//我喜欢的音乐
export function getLoveList(data){
    return postService('/loveList/getLoveList', data, showErrMsg)
}