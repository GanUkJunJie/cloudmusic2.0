<template>
    <div class="personality" ref="personality">
        <Carousel :banners="banners"/>
        <span class="recommend lightBlackTag">推荐歌单></span>
        <MusicBox :boxList="boxList"/>
    </div>
</template>
<script>
import Carousel from '@/components/carousel';
import MusicBox from '@/components/musicBox';
import loading from '@/mixin/loading';
import { carousel, musicList } from '@/api/discover-music/personality';
export default {
    name:'personality',
    mixins: [loading],
    components: {
        Carousel,
        MusicBox,
    },
    data() {
        return {
            banners: [],
            boxList: [],
        }
    },
    mounted() {
        this.load = this.loading('personality')
        this.getCarousel()
        this.getMusicList()
    },
    methods: {
        //获取轮播图
        getCarousel(){
            carousel().then(
                res => {
                    this.banners = res.banners
                }
            )
        },
        //获取歌单列表
        getMusicList(){
            musicList({
                limit: 10
            }).then(res => {
                this.boxList = res.result;
                this.load.close()
            })
        }
    },
}
</script>
<style scoped lang="scss">
    .recommend{
        font-weight: bold;
        font-size: 22px;
    }
</style>