<template>
    <div class="lyrics" ref="lyrics">
        <div
        class="lyric"
        :class="lyricsIndex-1 == index ? 'currentPlay' : ''"
        v-for="(item, index) in lyric"
        :key="index">
            {{ item[1] }}
        </div>
        <!-- 占位符 -->
        <div class="end"></div>
    </div>
</template>
<script>
export default {
    props: {
        lyric: {
            type:Array,
            default:() => [],
        }
    },
    data() {
        return {
            lyricsIndex: 0,//当前播放歌词
        }
    },
    watch: {
        '$store.getters.currentTime':{
            handler(val,oldVal){
                // 音乐切换
                if (val === 0) {
                    this.lyricsIndex = 0
                }
                //前后超过1s再重新定位，节流
                if (oldVal && Math.abs(val - oldVal) >= 1) {
                    this.getCurrentLyricsIndex(val)
                } else if (val >= this.lyric[this.lyricsIndex][0]) {
                    ++this.lyricsIndex
                }
                this.lyricScroll()
            }
        }
    },
    methods: {
        //获取歌词下标
        getCurrentLyricsIndex(val){
            let lyricsIndex = 0;
            this.lyric.some((item) => {
                if (lyricsIndex < this.lyric.length - 1) {
                    if (val > item[0]) {
                        lyricsIndex += 1;
                    }
                    return val <= item[0];
                }
            });
            this.lyricsIndex = lyricsIndex;
        },
        //歌词轮播
        lyricScroll(){
            this.$refs.lyrics.scrollTo({behavior: "smooth",top: this.lyricsIndex*45,})
        }
    },
}
</script>
<style scoped lang="scss">
.lyrics{
    margin-left: 200px;
    padding-top: 200px;
    width: 350px;
    height: 200px;
    text-align: center;
    overflow-y: scroll;
    .lyric{
        font-size: 15px;
        color: #606060;
        margin: 25px 0;
        transition: all 0.2s;
    }
    .currentPlay {
        font-weight: bold;
        font-size: 20px;
        color: #000000;
    }
    .end{
        height: 200px;
    }
}
</style>