<template>
    <div class="table">
        <el-table
            v-if="tableData.length !== 0"
            :show-header="false"
            :data="tableData"
            @row-dblclick="playMusic"
            :cell-class-name="cellClassName"
            stripe>
            <el-table-column
                type="index"
                width="50">
            </el-table-column>
            <el-table-column
                label="标题"
                prop="name"
                width="400"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                label="歌手"
                prop="ar"
                show-overflow-tooltip>
                <template slot-scope="scope">
                    <span v-for="(item, index) in scope.row.ar" :key="index">
                        <span> {{index + 1 === scope.row.ar.length ? item.name : item.name + " / "}} </span>
                    </span>
                </template>
            </el-table-column>
        </el-table>
        <span class="all" @click="playlistDetail">
            <span>查看全部</span>
            <i class="iconfont icon-right"></i>
        </span>
    </div>
</template>
<script>
import { playlistDetail } from '@/api/discover-music/playlist';
import { songDetail } from '@/api/song';
export default {
    props:{
        item: Object,
    },
    data() {
        return {
            selectTop: 5, //取前五首歌曲
            playlist: [],
            tableData: [] //歌曲列表
        }
    },
    computed: {
        trackIds() {
            if (this.playlist) {
                let arr = []
                this.playlist.map(item => arr.push(item.id))
                return arr
            }
        }
    },
    mounted() {
        this.getPlaylistDetail()
    },
    methods: {
        getPlaylistDetail(){
            playlistDetail({
                id: this.item && this.item.id
            }).then(res => {
                if (res.playlist && res.playlist.trackIds) {
                    this.playlist = res.playlist.trackIds.splice(0,this.selectTop)
                    this.getSongDetail()
                }
            })
        },
        getSongDetail(){
            songDetail({
                ids: this.trackIds.toString(),
            }).then(res => {
                this.tableData = res.songs
            })
        },
        playMusic(row){
            this.$store.dispatch('play/setPlaySongId',{
                playIdNow: row.id,
                playIdArr: this.trackIds
            })
        },
        playlistDetail(){
            this.$emit('playlistDetail',this.item.id)
        },
        cellClassName({rowIndex,columnIndex}){
            if (rowIndex < 3 && columnIndex === 0) {
                return 'topThree'
            }
            if (columnIndex === 2) {
                return 'right'
            }
        }
    },
}
</script>
<style scoped lang="scss">
.el-table{
    text-align: center;
    /deep/.el-table__cell{
        padding: 5px 0;
    }
    /deep/.topThree {
        color: #EC4141;
    }
    /deep/.right {
        text-align: right;
    }
}
.all {
    font-size: 12px;
    color: #373737;
    span { vertical-align: middle; }
    i {vertical-align: middle;}
    &:hover {
        color: #000000;
    }
}
</style>