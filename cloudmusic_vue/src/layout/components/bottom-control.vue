<template>
    <div class="center">
        <div class="control">
            <i class="iconfont icon-order"></i>
            <i class="iconfont icon-previous" @click="changeMusic('pre')"></i>
            <i class="iconfont icon-suspend" v-if="!playing" @click="setPlaying()"></i>
            <i class="iconfont icon-play" v-if="playing" @click="setPlaying()"></i>
            <i class="iconfont icon-next" @click="changeMusic('next')"></i>
            <span style="font-family: 'SimHei';font-size:13px">词</span>
        </div>
        <audio 
            ref="audio"
            :src="songUrl"
            autoplay
            @play="changeState(true)"
            @pause="changeState(false)"
            @ended="changeMusic('next')"
            @timeupdate="onTimeupdate"
        ></audio>
        <div class="slider">
            <span>{{ currentTime | realFormatSecond }}</span>
            <el-slider 
            v-model="currentTime" 
            :max="maxTime/1000" 
            :show-tooltip="false"
            @change="setMusicCurrent()"></el-slider>
            <span>{{ maxTime | realFormatSecond }}</span>
        </div>
    </div>
</template>
<script>
import { realFormatSecond } from '@/utils/tools';
import { songUrl } from '@/api/song';
export default {
    props:{
        songId: Number,
        maxTime:{ //总时长
            type: Number,
            default: 0
        }
    },
    data() {
        return {
            songUrl:'',
        }
    },
    computed: {
        //正在播放中
        playing: {
            get(){
                return this.$store.getters.playing
            },
            set(val){
                this.$store.dispatch('play/isPlaying',val)
            }
        },
        //当前播放时间
        currentTime: {
            get(){
                return this.$store.getters.currentTime
            },
            set(val){
                this.$store.dispatch('play/setCurrentTime',val)
            }
        }
    },
    watch: {
        songId:{
            handler(val,oldVal){
                this.getSongUrl()
            },
        }
    },
    methods: {
        getSongUrl(){
            songUrl({
                id: this.songId
            }).then(res => {
                this.songUrl = res.data && res.data[0] && res.data[0].url
            })
        },
        setMusicCurrent(){
            this.$refs.audio.currentTime = this.currentTime
        },
        setPlaying(){
            if (this.songUrl) {
                this.playing? this.$refs.audio.pause():this.$refs.audio.play()
            }
        },
        changeState(state){
            this.playing = state
        },
        changeMusic(val){
            this.$emit('changeMusic',val)
        },
        onTimeupdate(res){
            this.currentTime = res.target.currentTime
        }
    },
    filters: {
        realFormatSecond,
    },
}
</script>
<style lang="scss">
.center {
    margin-left: 170px;
    .control {
        padding-top: 10px;
        display: flex;
        margin: auto;
        justify-content: space-around;
        width: 260px;
    }
    .slider {
        display: flex;
        span {
            font-size: 12px;
            margin-top: 9px;
            color: #999999;
        }
        .el-slider {
            width: 380px;
            margin: 0 5px;
        }
    }
}
</style>