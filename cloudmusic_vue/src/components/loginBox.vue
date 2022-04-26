<template>
    <div class="login">
        <div style="margin: 0 auto;width: 100%;text-align: center;">
            <div class="phone"><img src="../assets/img/phone.png" alt=""></div>
            <div style="border-radius: 5px">
                <el-input v-model="tel" placeholder="请输入手机号" style="width: 300px;">
                    <el-select v-model="select"  slot="prepend" placeholder="请选择">
                        <el-option label="+86" value="1"></el-option>
                    </el-select>
                </el-input>
                <el-input v-model="pwd" placeholder="请输入密码" style="width: 300px;"></el-input>
            </div>
            <el-button :plain="true" @click="logging()">登录</el-button>
            <div @click="register()"><span style="border-bottom: 1px solid;">注册</span></div>
        </div>
    </div>
</template>
<script>
export default {
    name:'Login',
    data() {
        return {
            select:"1",
            tel:'',
            pwd:'',
        }
    },
    methods: {
        logging(){
            window.sessionStorage.setItem("tel", this.tel);
            this.$store.dispatch('user/getInfo')
            this.$emit('changeLogin', false);
        },
        register(){
            
        }
    },
}
</script>
<style scoped lang="scss">
    .login{
        width: 350px;
        height: 530px;
        box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
        background-color: white;
        z-index: 999;
        .phone{
            margin-top: 50px;
        }
        .el-select{
            width: 100px;
        }
        /deep/.el-button{
            width: 300px;
            margin: 20px 0;
            color: white;
            background-color: #EA4848;
            &:hover ,&:focus{
                color: white;
                background-color: #C72E2E;
                border-color: #C72E2E;
            }
        }
        /deep/.el-input__inner {
            &:focus {
                border-color: #D8D8D8;
            }
        }
    }
</style>