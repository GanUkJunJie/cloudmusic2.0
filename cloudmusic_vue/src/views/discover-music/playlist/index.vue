<template>
    <div class="playlist" ref="playlist">
        <div class="top">
            <div class="highest">
                <div class="background" :style='{"background-image":"url("+highest.coverImgUrl+")"}'></div>
            </div>
            <div class="detail">
                <PictureBox :src="highest.coverImgUrl" :size="140"/>
                <div class="detailInfo">
                    <CloudButton style="margin-bottom:20px" type="yellowButton" leftIcon="icon-crown" text="精品歌单" :width="100"/>
                    <p style="color:white;margin:5px 0">{{highest.name}}</p>
                    <span class="hWriter">{{highest.copywriter}}</span>
                </div>
            </div>
        </div>
        <Table/>
    </div>
</template>
<script>
import PictureBox from '@/components/pictureBox';
import CloudButton from '@/components/cloud-button';
import Table from './table';
import { hightQuality } from '@/api/discover-music/playlist';
import loading from '@/mixin/loading';
export default {
    mixins: [loading],
    components:{
        PictureBox,
        CloudButton,
        Table,
    },
    data() {
        return {
            cat: '全部',
            highest: {},
        }
    },
    mounted() {
        this.load = this.loading('playlist')
        this.getHightQuality()
    },
    methods: {
        getHightQuality() {
            hightQuality({
                cat: this.cat
            }).then(res => {
                this.highest = res.playlists[0]
                this.load.close()
            })
        }
    },
}
</script>
<style scoped lang="scss">
.playlist {
    margin-top: 20px;
    .top {
        position: relative;
        .highest {
            border-radius: 10px;
            overflow: hidden;
            height:170px;
            .background {
                width: 100%;
                height: 100%;
                background-position: center;
                filter: blur(30px) brightness(70%);
            }
        }
        .detail{
            position: absolute;
            top: 15px;
            left: 15px;
            display: flex;
            .detailInfo{
                margin: auto 10px;
                .hWriter{
                    font-size: 13px;
                    color: #BCB29F;
                }
            }
        }
    }
}
</style>