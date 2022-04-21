<template>
    <div class="album">
        <img src="@/assets/img/topSongsLogo.png">
        <div class="top">
            <div class="text">热门50首</div>
            <SongList :class="isFold" :trackIds="trackIds" :songCount="50" :show="show"/>
            <div class="all" @click="showAll">
                <span>查看全部</span>
                <i class="iconfont icon-right"></i>
            </div>
        </div>
    </div>
</template>
<script>
import SongList from '../../playlist/songList';
import { topFifty } from '@/api/discover-music/singer';
export default {
    props:{
        id:{
            type: Number
        }
    },
    components: {
        SongList,
    },
    data() {
        return {
            trackIds:[],
            show:{},
            isFold:'fold',
        }
    },
    watch: {
        id:{
            handler(val,oldVal){
                if (val) {
                    this.getTopFifty()
                }
            },
        }
    },
    methods: {
        getTopFifty(){
            topFifty({
                id: this.id
            }).then(res=> {
                res.songs.map(item => {
                    this.trackIds.push(item.id)
                    this.show = {
                        header: false, //表头
                        ar: false, // 歌手
                        al: false, //专辑
                        name: 600, //标题宽度
                    }
                })
            })
        },
        showAll(){
            this.isFold = 'unfold'
        }
    },
}
</script>
<style scoped lang="scss">
.album {
    display: flex;
    img{
        width: 150px;
        height: 150px;
    }
    .top {
        margin-left: 60px;
        width: 100%;
        .text{
            font-size: 16px;
            font-weight: bold;
        }
        .fold {
            /deep/.el-table {
                height: 340px;
            }
        }
        .unfold {
            /deep/.el-table {
                height: 1700px;
            }
        }
        .all {
            margin-top: 10px;
            font-size: 12px;
            color: #373737;
            span { vertical-align: middle; }
            i {vertical-align: middle;}
            &:hover {
                color: #000000;
            }
        }
    }
    
}
</style>