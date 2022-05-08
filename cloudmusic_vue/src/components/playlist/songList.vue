<template>
    <div class="songList">
        <el-table
            v-if="tableData.length !== 0"
            :show-header="show.header"
            :data="tableData"
            @row-dblclick="playMusic"
            :cell-class-name="cellClassName"
            stripe>
            <el-table-column
                type="index"
                width="50">
                <template slot-scope="scope">
                    <!-- 当前播放 -->
                    <span v-if="scope.row.id === currentId">
                        <i class="iconfont icon-currentPlay currentPlay"></i>
                    </span>
                    <!-- 下标 -->
                    <span v-else-if="scope.$index < 9">{{'0'+ (scope.$index+1)}}</span>
                    <span v-else>{{scope.$index+1}}</span>
                </template>
            </el-table-column>
            <el-table-column
                label="操作"
                width="70">
                <template slot-scope="scope">
                    <i v-if="likeId.indexOf(scope.row.id+'')>-1" class="iconfont icon-like" 
                        style="margin-right:10px;color:red"
                        @click="addLike(scope.row.id)"></i>
                    <i v-else class="iconfont icon-love"
                        style="margin-right:10px"
                        @click="addLike(scope.row.id)"></i>
                    <i class="iconfont icon-download"></i>
                </template>
            </el-table-column>
            <el-table-column
                label="标题"
                prop="name"
                :width="show.name"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                v-if="show.ar"
                label="歌手"
                prop="ar"
                show-overflow-tooltip>
                <template slot-scope="scope">
                    <span v-for="(item, index) in scope.row.ar" :key="index">
                        <span> {{index + 1 === scope.row.ar.length ? item.name : item.name + " / "}} </span>
                    </span>
                </template>
            </el-table-column>
            <el-table-column
                v-if="show.ar"
                label="专辑"
                prop="al.name"
                width="250"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                label="时间"
                prop="dt">
                <template slot-scope="scope">
                    {{scope.row.dt | realFormatSecond }}
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>
<script>
import { songDetail } from '@/api/song';
import { getLike,addLike } from '@/api/service';
import { realFormatSecond } from '@/utils/tools';
export default {
    props:{
        //歌曲id
        trackIds: Array,
        //获取歌曲数量
        songCount: {
            type: Number,
            default: 20,
        },
        show: {
            type: Object,
            default: () => ({
                header: true, //表头
                ar: true, // 歌手
                al: true, //专辑
                name: 400, //标题宽度
            })
        }
    },
    data() {
        return {
            tableData: [], //歌单
            currentId: '',
            likeId: [],
        }
    },
    computed: {
        uuid(){
            return this.$store.getters.user.uuid
        }
    },
    watch: {
        trackIds:{
            handler(val,oldVal){
                if (val) {
                    this.getLike()
                    this.getSongDetail()
                }
            }
        },
        '$store.getters.playSong':{
            handler(val,oldVal){
                this.currentId  = val.playIdNow
            },
        }
    },
    methods: {
        getLike(){
            if (!this.uuid) return
            const songIds = this.trackIds.slice(0, this.songCount).toString()
            getLike({
                uuid: this.uuid,
                songIds: songIds
            }).then(res => {
                this.likeId = res.result
            })
        },
        addLike(songId){
            if (!this.uuid) {
                this.$noUserLogin()
                return
            }
            addLike({
                uuid: this.uuid,
                songId: songId + '',
            }).then(res => {
                this.$message({message: res.message,type: 'success'});
                this.getLike()
            })
        },
        getSongDetail(){
            songDetail({
                ids: this.trackIds.slice(0, this.songCount).toString(),
            }).then(res => {
                console.log(res.songs);
                this.tableData = res.songs
            })
        },
        playMusic(row){
            this.currentId = row.id
            this.$store.dispatch('play/setPlaySongId',{
                playIdNow: row.id,
                playIdArr: this.trackIds.slice(0, this.songCount)
            })
        },
        cellClassName({row,columnIndex}){
            if (columnIndex === 0) {
                return 'indexCell'
            }

            if (row.id === this.currentId && columnIndex === 2) {
                return 'currentPlay'
            }
        }
    },
    filters: {
        realFormatSecond,
    },
}
</script>
<style scoped lang="scss">
.songList {
    .el-table{
        text-align: center;
        /deep/.el-table__cell{
            padding: 5px 0;
        }
        /deep/.indexCell {
            text-align: right !important;
        }
        /deep/.currentPlay {
            color: #EC4141;
        }
    }
}

</style>