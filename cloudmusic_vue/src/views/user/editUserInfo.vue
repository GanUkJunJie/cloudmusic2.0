<template>
    <div class="editUserInfo">
        <p>编辑个人信息</p>
        <el-form ref="userInfo" :model="base" :rules="rules" label-width="60px">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="昵称：" prop="name">
                        <el-input v-model="base.name"></el-input>
                    </el-form-item>
                    <el-form-item label="介绍：">
                        <el-input type="textarea" v-model="base.intro"></el-input>
                    </el-form-item>
                    <el-form-item label="性别：">
                        <el-radio-group v-model="base.sex">
                            <el-radio :label="1">男</el-radio>
                            <el-radio :label="0">女</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="生日：">
                        <el-select class="birth" v-model="base.birthYear" placeholder="">
                            <el-option v-for="item in year" :key="item" :label="item" :value="item"></el-option>
                        </el-select>
                        <el-select class="birth" v-model="base.month" placeholder="">
                            <el-option v-for="item in month" :key="item" :label="item" :value="item"></el-option>
                        </el-select>
                        <el-select class="birth" v-model="base.day" placeholder="">
                            <el-option v-for="item in day" :key="item" :label="item" :value="item"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="地址：">
                        <el-input v-model="base.address"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="danger" round @click="submit">保存</el-button>
                        <el-button class="cancel" round @click="cancel">取消</el-button>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item>
                        <div class="userCover">
                            <img src="@/assets/img/user.jpg">
                            <el-button class="cancel" style="margin-left:30px" round>修改头像</el-button>
                        </div>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
    </div>
</template>
<script>
import {year, month, day} from '@/common/date.js';
export default {
    name:'UpdateUerInfo',
    data() {
        const validatorName = (rule,value,callback) => {
            if (value === '') {
                callback(new Error('请输入昵称'))
            }
        }
        return {
            year,
            month,
            day,
            base:{
                name:'',
                intro: '',
                sex: 1,
                birthYear: '',
                birthMonth: '',
                birthDay: '',
                address: '',
            },
            rules: {
                name: [
                    { validator: validatorName, trigger: 'blur' },
                ],
            }
        }
    },
    methods: {
        submit(){
            this.$refs['userInfo'].validate((valid) => {
                if (valid) {
                    
                }
            })
        },
        cancel(){
            this.$router.push({ 
            name: 'userInfo',
            query: {
                id: this.$route.query.id,
            }
        })
        }
    },
}
</script>
<style scoped lang="scss">
.editUserInfo {
    // width: 450px;
    p {
        font-weight: bold;
        font-size: 20px;
    }
    /deep/.el-form-item {
        .el-form-item__label{
            text-align: left;
        }
    }
    /deep/.el-input__inner{
        height: 30px;
    }
    /deep/.el-button {
        padding: 8px 30px;
    }
    .cancel {
        &:hover,&:focus {
            color: #606266;
            border-color: #D8D8D8;
            background-color: #F2F2F2;
        }
    }
    .birth{
        width: 140px;
        margin-right: 5px;
    }
    .userCover {
        width: 185px;
        height: 185px;
        img {
            width: 100%;
            height: 100%;
            border-radius: 10px;
        }
    }
}
</style>