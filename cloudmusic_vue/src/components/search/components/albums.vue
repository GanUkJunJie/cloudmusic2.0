<template>
    <div ref="searchAlbums">
        <el-table
        :show-header="false"
        :data="albums"
        stripe>
            <el-table-column width="80">
                <template slot-scope="scope">
                    <PictureBox :src="scope.row.picUrl" :size="60"/>
                </template>
            </el-table-column>
            <el-table-column
                prop="name"
                width="400">
            </el-table-column>
            <el-table-column
                prop="artist.name">
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
            albums:[],
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
                        this.load = this.loading('searchAlbums')
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
            let res = await cloudsearch({keywords: this.keywords, type: 10});
            this.albums = res.result.albums || [];
            this.load.close()
        }
    },
}
</script>
<style lang="scss">
    
</style>