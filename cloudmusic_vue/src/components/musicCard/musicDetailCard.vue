<template>
    <div :class="{hide: !drawer}">
        <div v-if="drawer" class="musicDetailCard">
            <div class="top">
                <i @click="handleClose()" class="iconfont icon-arrow-down close"></i>
            </div>
            <div class="musicDetailInfo">
                <div class="musicInfo">
                    <div class="title">
                        <div class="name">{{song.name}}</div>
                        <div class="artist">
                            <span>{{artists}}</span>
                            - 
                            <span>{{song.name}}</span>
                        </div>
                    </div>
                    <div style="display:flex">
                        <div class="dishes">
                            <div class="needle" :class="{needleRotate: playing}">
                                <img src="@/assets/img/needle.png">
                            </div>
                            <div class="picture pictureAnimation" :class="{pause: !playing}">
                                <img class="disc" src="@/assets/img/disc.png">
                                <img class="picUrl" :src="picUrl">
                            </div>
                        </div>
                        <LyricsScroll :lyric="lyric"/>
                    </div>
                    <Comments title="热门评论" :comments="allComments.hotComments"/>
                    <Comments title="最新评论" :comments="allComments.comments" :total="allComments.total"/>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import { songDetail, songLyrics } from '@/api/song';
import { songComments } from '@/api/comments';
import LyricsScroll from './lyrics-scroll';
import Comments from '@/components/comments';
export default {
    components: {
        LyricsScroll,
        Comments,
    },
    data() {
        return {
            song: {},
            lyric: [[0, "正在加载歌词"]],//加工后的歌词['时间'，'对应歌词']
            allComments:[],
        }
    },
    computed: {
        playing(){
            return this.$store.getters.playing
        },
        drawer(){
            return this.$store.getters.drawer
        },
        picUrl(){
            return this.song && this.song.al && this.song.al.picUrl
        },
        artists(){
            return this.song.ar?.map(item => {
                return item.name
            }).join('/')
        }
    },
    watch: {
        '$store.getters.playSong':{
            handler(val,oldVal){
                this.lyric = [[0, "正在加载歌词"]];
                this.getSongDetail(val.playIdNow)
                this.getSongLyrics(val.playIdNow)
                this.getSongComments(val.playIdNow)
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
        getSongLyrics(id){
            songLyrics({
                id: id
            }).then(res => {
                this.dealLyrics(res && res.lrc && res.lrc.lyric)
            })
        },
        getSongComments(id){
            songComments({
                id: id
            }).then(res => {
                this.allComments = res
            })
        },
        //对歌词加工
        dealLyrics(data) {
            let arr = data.split('\n')
            let time,value,result=[]
            arr.forEach((item) => {
                time = item.split("]")[0];
                value = item.split("]")[1];
                let t = time.slice(1).split(":");
                result.push([parseInt(t[0], 10) * 60 + parseFloat(t[1]), value]);
            });
            //去除空行
            this.lyric = result.filter(item => {
                if (item[1] !== '') {
                    return item
                }
            })
        },
        handleClose(){
            this.$store.dispatch('play/showDrawer',false)
        }
    },
}
</script>
<style scoped lang="scss">
@import './musicDetailCard.scss';
</style>