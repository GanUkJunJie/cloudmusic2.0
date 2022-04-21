<template>
    <div class="newSongList" ref="newSongList">
        <el-table
            v-if="tableData.length !== 0"
            :show-header="false"
            :data="tableData"
            @row-dblclick="playMusic"
            :cell-class-name="cellClassName"
            stripe>
            <el-table-column
                type="index"
                width="60">
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
                width="70">
                <template slot-scope="scope">
                    <PictureBox :src="scope.row.album.blurPicUrl" :size="60"/>
                </template>
            </el-table-column>
            <el-table-column
                prop="name"
                width="400"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                width="250"
                show-overflow-tooltip>
                <template slot-scope="scope">
                    <span v-for="(item, index) in scope.row.artists" :key="index">
                        {{item.name}}
                        <span v-if="index<scope.row.artists.length-1">/</span>
                    </span>
                </template>
            </el-table-column>
            <el-table-column
                prop="album.name"
                width="200">
            </el-table-column>
            <el-table-column
                label="时间"
                prop="dt">
                <template slot-scope="scope">
                    {{scope.row.duration | realFormatSecond }}
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>
<script>
import PictureBox from '@/components/pictureBox';
import { newSong } from '@/api/discover-music/newSongs';
import { realFormatSecond } from '@/utils/tools';
import loading from '@/mixin/loading';
export default {
    mixins: [loading],
    props:{
        type: Number,
    },
    components: {
        PictureBox,
    },
    data() {
        return {
            tableData: [], //新歌列表
            limit: 20, //只取20个
            currentId: '',
        }
    },
    computed: {
        trackIds(){
            return this.tableData.map(item => {
                return item.id
            })
        }
    },
    watch: {
        type:{
            handler(val,oldVal){
                if (val !== undefined) {
                    this.$nextTick(() => {
                        this.load = this.loading('newSongList')
                    });
                    this.getNewSong()
                }
            },
            immediate: true
        }
    },
    methods: {
        getNewSong(){
            newSong({
                type: this.type,
            }).then(res => {
                this.tableData = res.data.slice(0, this.limit)
                this.load.close()
            })
        },
        playMusic(row){
            this.currentId = row.id
            this.$store.dispatch('play/setPlaySongId',{
                playIdNow: row.id,
                playIdArr: this.trackIds
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
.newSongList {
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