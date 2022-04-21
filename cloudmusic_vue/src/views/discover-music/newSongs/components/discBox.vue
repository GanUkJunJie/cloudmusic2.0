<template>
    <div class="discBox" ref="discBox">
        <div
            class="box"
            v-for="(item,index) in boxList"
            :key="index"
            @click="playMusic(item.id)">
            <div class="img">
                <PictureBox :src="item.blurPicUrl" :size="155"/>
            </div>
            <MusicDescribe :describe="item.name"/>
            <MusicDescribe class="artist" :describe="item.artist.name"/>
        </div>
    </div>
</template>
<script>
import PictureBox from '@/components/pictureBox';
import MusicDescribe from '@/components/musicDescribe';
import { album } from '@/api/discover-music/newSongs';
import loading from '@/mixin/loading';
export default {
    mixins: [loading],
    name: 'discBox',
    props: {
        area: String,
    },
    components: {
        PictureBox,
        MusicDescribe,
    },
    data() {
        return {
            boxImgShow: [],//图片未加载时，显示骨架
            boxList: [],
            limit: 10,
        }
    },
    computed: {
        trackIds(){
            return this.boxList.map(item => {
                return item.id
            })
        }
    },
    watch:{
        area:{
            handler(val,oldVal){
                if (val !== undefined) {
                    this.$nextTick(() => {
                        this.load = this.loading('discBox')
                    });
                    this.getNewAlbum()
                }
            },
            immediate: true
        }
    },
    methods: {
        playMusic(id) {
            this.$store.dispatch('play/setPlaySongId',{
                playIdNow: id,
                playIdArr: this.trackIds
            })
        },
        getNewAlbum(){
            album({
                area: this.area,
                limit: this.limit,
                offset: 0,
            }).then(res => {
                this.boxList = res.weekData.slice(0, this.limit)
                this.boxImgShow = new Array(this.boxList.length).fill(true)
                this.load.close()
            })
        },
    },
}
</script>
<style scoped lang="scss">
.discBox {
    padding: 10px 0;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    .box {
        position: relative;
        margin-bottom: 90px;
        width: 190px;
        height: 155px;
        .img {
            background-image: url('../../../../assets/img/coverall.png');
            background-position: 10% 74%;
            height: 155px;
        }
        .artist{
            color: #9F9F9F;
            &:hover {
                color: #676767;
            }
        }
    }
}
</style>