<template>
    <div ref="searchPlaylist">
        <el-table
        :show-header="false"
        :data="playlists"
        stripe>
            <el-table-column width="80">
                <template slot-scope="scope">
                    <PictureBox :src="scope.row.coverImgUrl" :size="60"/>
                </template>
            </el-table-column>
            <el-table-column
                prop="name"
                width="400">
            </el-table-column>
            <el-table-column
                width="80">
                <template slot-scope="scope">
                    {{scope.row.trackCount}}首
                </template>
            </el-table-column>
            <el-table-column>
                <template slot-scope="scope">
                    by{{scope.row.creator.nickname}}
                </template>
            </el-table-column>
            <el-table-column>
                <template slot-scope="scope">
                    <i class="iconfont icon-amountPlay"></i>
                    {{(scope.row.playCount/10000).toFixed(0)}}万
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>
<script>
import loading from '@/mixin/loading';
import { cloudsearch } from '@/api/search';
import PictureBox from '@/components/pictureBox';
export default {
    mixins: [loading],
    data() {
        return {
            playlists:[],
            keywords:'',
        }
    },
    components:{
        PictureBox,
    },
    watch: {
        '$route.query.keywords':{
            handler(val,oldVal){
                if (val) {
                    this.$nextTick(() => {
                        this.load = this.loading('searchPlaylist')
                    });
                    this.keywords = val
                    this.getCloudsearch()
                }
            },
            immediate:true
        }
    },
    methods: {
        async getCloudsearch(){
            let res = await cloudsearch({keywords: this.keywords, type: 1000});
            this.playlists = res.result.playlists || [];
            this.load.close()
        }
    },
}
</script>
<style lang="scss">
    
</style>