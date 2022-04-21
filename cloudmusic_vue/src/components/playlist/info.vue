<template>
    <div class="info" ref="info">
        <div class="title">
            <span>歌单</span>
            <h2>{{ playlist.name }}</h2>
        </div>
        <div class="author">
            <el-avatar class="avatar" :src="playlist.creator? playlist.creator.avatarUrl:''"></el-avatar>
            <span style="margin-left: 10px;" class="lightBlueTag">{{ playlist.creator? playlist.creator.nickname:'' }}</span>
            <span style="margin-left: 10px;">{{ playlist.createTime | showData }} 创建</span>
        </div>
        <div class="opButton">
            <CloudButton :width="130" type="redButton" leftIcon="icon-suspend" text="播放全部" rightIcon="icon-add"/>
            <CloudButton :width="130" leftIcon="icon-collection" :text="`收藏(${getPlayCount(playlist.subscribedCount)})`"/>
            <CloudButton :width="130" leftIcon="icon-forward" :text="`分享(${getPlayCount(playlist.shareCount)})`"/>
            <CloudButton :width="130" leftIcon="icon-download" text="下载全部"/>
        </div>
        <div class="describe">
            标签：<span
                    v-for="(item, index) in this.playlist.tags"
                    :key="index">
                    <span class="lightBlueTag"> {{index + 1 === playlist.tags.length ? item : item + " / "}} </span>
                </span>
            <div style="line-height:30px">
                <span style="margin-right:10px">歌曲：{{ playlist.trackCount }}</span>
                <span>播放：{{ getPlayCount(playlist.playCount) }}</span>
            </div>
            <el-collapse>
                <el-collapse-item :title="'简介：'+ introduceTitle">
                    <div 
                        v-for="(item, index) in describe" 
                        :key="index">
                        {{ describe[index] }}
                    </div>
                </el-collapse-item>
            </el-collapse>
        </div>
    </div>
</template>
<script>
import CloudButton from '@/components/cloud-button';
import { formatDate } from '@/utils/tools';
import loading from '@/mixin/loading';
export default {
    mixins: [loading],
    props: {
        playlist: Object
    },
    components: {
        CloudButton,
    },
    data() {
        return {
            introduceTitle:'',
        }
    },
    mounted() {
        this.load = this.loading('info')
    },
    computed: {
        describe(){
            if (this.playlist.description) {
                let description = this.playlist.description.split('\n')
                this.introduceTitle = description.shift()
                return description
            }
        }
    },
    watch: {
        playlist:{
            handler(val,oldVal) {
                if (val) {
                    this.load.close()
                }
            }
        }
    },
    methods: {
        //播放量
        getPlayCount(playCount) {
            if (playCount > 10000) {
                return (playCount/10000).toFixed(0)+"万"
            }
            return playCount
        },
    },
    filters: {
        showData: function (time) {
            let date = new Date(time)
            return formatDate(date, 'yyyy-MM-dd')
        }
    }
    
}
</script>
<style scoped lang="scss">
.info {
    margin-left: 20px;
    font-size: 13px;
    .title {
        display: flex;
        padding-bottom: 5px;
        span {
            margin: auto 0;
            font-size: 12px;
            color: #EC4141;
            border: 1px solid #EC4141;
            border-radius: 3px;
            padding: 1px 5px;
        }
        h2 {
            margin: 0 10px;
        }
    }
    .author {
        display: flex;
        align-items: center;
        color: #676767;
        font-size: 13px;
        padding-bottom: 5px;
        .avatar {
            width: 25px;
            height: 25px;
        }
    }
    .opButton {
        display: flex;
        width: 550px;
        justify-content: space-between;
        padding-bottom: 10px;
        button {
            span {
                padding: 0 5px;
            }
        }
    }
    .describe{
        /deep/.el-collapse {
            border: 0;
            .el-collapse-item__header{
                border: 0;
                height: 50px;
                line-height: 2;
                width: 800px;
            }
            .el-collapse-item__content {
                width: 800px;
            }
        }
    }
}
</style>