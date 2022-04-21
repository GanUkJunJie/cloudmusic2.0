<template>
    <div class="musicBox">
        <div
            class="box"
            :style="boxStyle"
            v-for="(item,index) in boxList"
            :key="index"
            @click="detail(item.id)">
            <span v-if="showPlayCount" class="playCount">
                <i class="iconfont icon-playAmount"></i>
                {{ getPlayCount(item.playCount) }}
            </span>
            <PictureBox :src="item.picUrl || item.coverImgUrl" :size="size"/>
            <MusicDescribe :describe="item.name"/>
        </div>
    </div>
</template>
<script>
import PictureBox from './pictureBox';
import MusicDescribe from './musicDescribe';
export default {
    name: 'MusicBox',
    props: {
        type: {
            type: String,
            default: 'playlist'
        },
        boxList: {
            type: Array,
            default: () => ([])
        },
        showPlayCount: {
            type: Boolean,
            default: () => true
        },
        size: {
            type: Number,
            default: 190
        }
    },
    components: {
        PictureBox,
        MusicDescribe,
    },
    data() {
        return {
            boxImgShow: [],//图片未加载时，显示骨架
        }
    },
    computed: {
        boxStyle() {
            return {
                width: this.size + 'px',
                height: this.size + 'px',
            }
        }
    },
    watch:{
        boxList:{
            handler(val,oldVal){
                this.boxImgShow = new Array(this.boxList.length).fill(true)
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
        //详情页
        detail(id) {
            switch(this.type) {
                //歌单详情页
                case 'playlist':
                    this.$router.push({ 
                        name: 'playlistDetail',
                        query: {
                            id:id,
                        }
                    })
                ;break;
                //歌手详情页
                case 'artists':
                    this.$router.push({ 
                        name: 'artistDetail',
                        query: {
                            id:id,
                        }
                    })
                ;break;
            }
        }
    },
}
</script>
<style scoped lang="scss">
.musicBox {
    padding: 10px 0;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    .box {
        position: relative;
        margin-bottom: 70px;
        .playCount {
            position: absolute;
            font-size: 12px;
            color: white;
            background-image: linear-gradient(to left, rgba(0, 0, 0, 0.2), rgba(255, 255, 255, 0));
            top: 5px;
            right: 5px;
            z-index: 1;
        }
    }
}
</style>