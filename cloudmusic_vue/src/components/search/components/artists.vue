<template>
    <div ref="searchArtists">
        <el-table
        :show-header="false"
        :data="artists"
        stripe>
            <el-table-column width="80">
                <template slot-scope="scope">
                    <PictureBox :src="scope.row.picUrl" :size="60"/>
                </template>
            </el-table-column>
            <el-table-column
                prop="name">
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
            artists:[],
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
                        this.load = this.loading('searchArtists')
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
            let res = await cloudsearch({keywords: this.keywords, type: 100});
            this.artists = res.result.artists || [];
            this.load.close()
        }
    },
}
</script>
<style lang="scss">
    
</style>