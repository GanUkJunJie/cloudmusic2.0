<template>
    <div class="appFooter">
        <div class="left">
            <el-avatar v-if="songPicUrl" style="border-radius:10px" shape="square" 
            :size="50" fit="fill"  :src="songPicUrl"  @click.native="showDrawer"></el-avatar>
            <div v-if="Object.keys(song).length !== 0" class="songTitle">
                <div style="display:flex">
                    <div class="songName" @mouseenter="marquee">
                        <span :class="subtitles"> 
                            <span id="name1">{{songName}}</span>
                            <span v-if="subtitles">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{songName}}
                            </span>
                        </span>
                    </div>
                    <span class="love"><i class="iconfont icon-love"></i></span>
                </div>
                <div class="singers">{{singersName}}</div>
            </div>
        </div>
        <BottomControl :songId="song.id" @changeMusic="changeMusic" :maxTime="song.dt"/>
        <BottomRight/>
    </div>
</template>
<script>
import BottomControl from './bottom-control';
import BottomRight from './bottom-right';
import { songDetail } from '@/api/song';
export default {
    components:{
        BottomRight,
        BottomControl,
    },
    data() {
        return {
            song:{},
            songIds:[],
            subtitles:'',//跑马灯样式
            timer:'',//跑马灯计时器
        }
    },
    computed:{
        songPicUrl() {
            return this.song.al?.picUrl ? this.song.al.picUrl : ''
        },
        songName() {
            return this.song.name ? this.song.name : '网易云音乐'
        },
        singersName() {
            return this.song.ar?.map(item => {
                return item.name
            }).join('/')
        },
    },
    watch: {
        '$store.getters.playSong':{
            handler(val,oldVal){
                this.getSongDetail(val.playIdNow)
                this.songIds = val.playIdArr
            },
        }
    },
    methods: {
        getSongDetail(id){
            songDetail({
                ids: id
            }).then(res => {
                this.song = res.songs[0]
            })
        },
        changeMusic(val){
            const index = this.songIds.indexOf(this.song.id)
            let playIdNow
            if (val === 'next') {
                playIdNow = index >= this.songIds.length - 1 ? this.songIds[0] : this.songIds[index + 1]
            } else if (val === 'pre') {
                playIdNow = index <= 0? this.songIds[this.songIds.length - 1] : this.songIds[index - 1]
            }
            this.$store.dispatch('play/setPlaySongId',{
                playIdNow: playIdNow,
                playIdArr: this.songIds
            })
        },
        //歌名轮播
        marquee(){
            if (document.getElementById('name1').offsetWidth <= 150) {
                return
            }
            // debugger
            if (this.timer) {
                return //跑马灯计时器已存在
            }
            this.subtitles = 'songNameMarquee'
            this.timer = setTimeout(()=>{
                this.subtitles = '' //清除跑马灯
                this.timer = '' //清除计时器
            },7000)
            
        },
        showDrawer(){
            this.$store.dispatch('play/showDrawer',!this.$store.getters.drawer)
        }
    },
}
</script>   

<style scoped lang="scss">
.appFooter{
    display: flex;
    width: 100%;
    .left{
        display: flex;
        width: 235px;
        .songTitle {
            margin-left: 10px;
            .songName {
                padding-top: 5px;
                font-size:15px;
                position: relative;
                max-width: 150px;
                overflow: hidden;
                white-space: nowrap;
                display: flex;
            }
            .songNameMarquee {
                animation: subtitles 7s linear;
            }
            .love {
                margin-left: 5px;
                line-height: 30px;
            }
            .singers {
                font-size:13px;
                // white-space: nowrap;
            }

            @keyframes subtitles {
                from {
                    transform: translateX(0);
                }
                to {
                    transform: translateX(-50%);
                }
            }
        }
    }
}
</style>