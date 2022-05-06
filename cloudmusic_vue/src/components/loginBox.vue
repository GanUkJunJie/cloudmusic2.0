<template>
    <div class="login">
        <div style="margin: 0 auto;width: 100%;text-align: center;">
            <div class="phone"><img src="../assets/img/phone.png" alt=""></div>
            <div style="border-radius: 5px">
                <el-form :model="user" :rules="rules" ref="users">
                    <el-form-item prop="tel">
                        <el-input v-model="user.tel" placeholder="请输入手机号" style="width: 300px;">
                            <el-select v-model="select"  slot="prepend" placeholder="请选择">
                                <el-option label="+86" value="1"></el-option>
                            </el-select>
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="pwd">
                        <el-input v-model="user.pwd" placeholder="请输入密码" show-password style="width: 300px;"></el-input>
                    </el-form-item>
                </el-form>
            </div>
            <el-button :plain="true" @click="logging()">登录</el-button>
            <div @click="register()"><span style="border-bottom: 1px solid;">注册</span></div>
        </div>
    </div>
</template>
<script>
import { register, login } from '@/api/service';
export default {
    name:'Login',
    data() {
        const validatorTel = (rule,value,callback) => {
            const reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/
            if (!reg.test(value)) {
                callback(new Error('请输入正确的手机号'))
            } else {
                callback()
            }
        }
        return {
            select:"1",
            user:{
                tel:'',
                pwd:'',
            },
            rules:{
                tel:[
                    { required:true, validator: validatorTel, trigger: 'blur' },
                ],
                pwd:[
                    { required:true, min:6, max:10, message:'请输入正确的密码', trigger: 'blur' },
                ],
            }
        }
    },
    methods: {
        validateForm(){
            return new Promise((resolve,reject) => {
                this.$refs.users.validate(valid => {
                    if (valid) { resolve(true) }
                    resolve(false)
                })
            })
        },
        async logging(){
            const valid = await this.validateForm()
            if (!valid) return
            login({
                tel: this.user.tel,
                password: this.user.pwd,
            }).then(res => {
                window.sessionStorage.setItem("uuid", res.result);
                this.$store.dispatch('user/getInfo')
                this.$message({message: res.message,type: 'success'});
                this.$emit('changeLogin', false);
                location.reload();
            })
        },
        async register(){
            const valid = await this.validateForm()
            if (!valid) return
            register({
                tel: this.user.tel,
                password: this.user.pwd,
            }).then(res => {
                this.$message({message: res.message,type: 'success'});
                this.$emit('changeLogin', false);
            })
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
        /deep/.el-form-item__error{
            width: 160px;
        }
    }
</style>