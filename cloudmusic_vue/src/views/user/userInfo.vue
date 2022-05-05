<template>
    <div>
        <div class="userInfo">
            <div class="userCover">
                <img :src="user.avatar">
            </div>
            <div class="info">
                <div style="border-bottom: 1px solid #E5E5E5;width: 800px;">
                    <div class="name">{{dynamic.name}}</div>
                    <div style="display: flex;align-items: center;margin-bottom: 10px;">
                        <button class="level">Lv{{dynamic.level}}</button>
                        <i v-if="dynamic.sex === 1" class="iconfont icon-male" style="background-color:#C0F3FF"></i>
                        <i v-else class="iconfont icon-female" style="background-color:#FFCDE8"></i>
                        <button class="compile" @click="update">
                            <i class="iconfont icon-compile"></i>
                            编辑个人信息
                        </button>
                    </div>
                </div>
                <div class="states">
                    <div class="state">
                        <div>{{dynamic.state}}</div><div>动态</div>
                    </div>
                    <div class="state">
                        <div>{{dynamic.focus}}</div><div>关注</div>
                    </div>
                    <div class="state">
                        <div>{{dynamic.fans}}</div><div>粉丝</div>
                    </div>
                </div>
                <div>
                    <div style="font-size:14px">社交网络:
                        <i style="font-size:20px;color:#B5B4B4" class="iconfont icon-weibo"></i>
                    </div>
                    <div style="font-size:14px">个人介绍: </div>
                </div>
            </div>
        </div>
        <myMusic/>
    </div>
</template>
<script>
import myMusic from './myMusic';
import { userDynamic } from '@/api/service';
export default {
    components: {
        myMusic,
    },
    data() {
        return {
            dynamic: {},
        };
    },
    computed:{
        uuid(){
            return this.$route.query.uuid
        },
        user(){
            return this.$store.getters.user
        }
    },
    mounted() {
        this.getUserDynamic()
    },
    methods: {
        getUserDynamic(){
            userDynamic({
                uuid: this.uuid,
            }).then(res => {
                this.dynamic = res.result
            })
        },
        update(){
            this.$router.push({ 
                name: 'editUserInfo',
                query: {
                    uuid: this.uuid,
                }
            })
        }
    },
}
</script>
<style scoped lang="scss">
    .userInfo {
        margin: 30px 0;
        display: flex;
        .userCover {
            width: 185px;
            height: 185px;
            img {
                width: 100%;
                height: 100%;
                border-radius: 50%;
            }
        }
        .info {
            position: relative;
            margin-left: 20px;
            .name {
                font-weight: bold;
                font-size: 25px;
                padding-bottom: 10px;
            }
            .level {
                border: 0;
                border-radius: 10px;
                margin-right: 5px;
            }
            i {
                border-radius: 50%;
            }
            .compile {
                position: absolute;
                right: 0;
                padding: 5px 10px;
                border: 1px solid #D8D8D8;
                border-radius: 20px;
                color: black;
                background-color: white;
                cursor: pointer;
                &:hover {
                    background-color: #F2F2F2;
                }
            }
            .states{
                display: flex;
                margin: 10px 0 10px -25px;
                .state{
                    width: 80px;
                    text-align: center;
                    font-size: 12px;
                    & > div:first-child{
                        font-weight: 350;
                        font-size: 20px;
                    }
                }
            }
        }
    }
</style>