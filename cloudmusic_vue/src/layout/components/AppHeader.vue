<template>
  <div class="appHeader">
    <div>
      <img src="@/assets/img/logo.png">
    </div>
    <div class="center">
      <div class="arrow">
        <i class="iconfont icon-arrow-left-bold circle" @click="$router.go(-1)"></i>
        <i class="iconfont icon-arrow-right-bold circle" @click="$router.go(1)"></i>
      </div>
      <SearchList/>
      <div class="arrow">
        <i class="iconfont icon-microphone circle" style="font-size:18px" @click="$undeveloped()"></i>
      </div>
    </div>
    <div class="right">
      <div @click="handleUser">
        <el-avatar class="user" :size="35" :src="user.avatar"> 
          <i class="iconfont icon-login"></i>
        </el-avatar>
        <span class="text">{{user.name || '未登录'}}</span>
        <i class="el-icon-caret-bottom"></i>
      </div>
      <span class="text" @click="$undeveloped()">开通VIP</span>
      <div class="operation">
        <i class="iconfont icon-zhuti"></i>
        <i class="iconfont icon-shezhi"></i>
        <i class="iconfont icon-youjian"></i>
        <i class="iconfont icon-fenge"></i>
        <i class="iconfont icon-minimize"></i>
        <i class="iconfont icon-minimizing"></i>
        <i class="iconfont icon-zuidahua"></i>
        <i class="iconfont icon-guanbi"></i>
      </div>
    </div>
    <LoginBox v-if="login" @changeLogin="changeLogin" class="login"/>
  </div>
</template>
<script>
import SearchList from '@/components/search/searchList';
import LoginBox from '@/components/loginBox';
export default {
  data() {
    return {
      searchInput: '',
      login: false,
    };
  },
  computed: {
    user(){
      return this.$store.getters.user
    }
  },
  components: {
    SearchList,
    LoginBox,
  },
  methods: {
    handleUser(){
      if (this.user.uuid) {
        this.$router.push({ 
            name: 'userInfo',
            query: {
                uuid: this.user.uuid,
            }
        })
        return;
      }
      this.login = !this.login
    },
    changeLogin(val){
      this.login = val
    }
  },
}
</script>
<style scoped lang="scss">
  .appHeader {
    margin: auto 0;
    display: flex;
    i {
      color: #FAD3D1;
    }
    .center{
      display: flex;
      align-items: center;
      margin-left: 60px;
      .arrow{
        i {
          background-color: #E94D47;
          font-size: 14px;
        }
        
      }
    }
    .right{
      display: flex;
      align-items: center;
      margin-left: 300px;
      .user {
        i { 
          color: #FFFFFF;
          font-size: 18px;
        }
        vertical-align: middle;
        background-color: #E0E0E0;
      }
      .text {
        margin-left: 5px;
        font-family: serif;
        font-size: 12px;
        color: #FAD3D1
      }
      .operation {
        margin-left: 20px;
        letter-spacing: 18px;
        i {
          font-size: 18px;
        }
      }
    }
    .login {
      position: fixed;
      margin: auto;
      top: 0px;
      bottom: 0px;
      left: 0px;
      right: 0px;
    }
  }
</style>