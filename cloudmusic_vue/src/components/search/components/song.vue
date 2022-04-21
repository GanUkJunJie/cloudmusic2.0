<template>
    <div ref="searchSongs">
        <SongList :trackIds="trackIds" />
    </div>
</template>
<script>
import loading from '@/mixin/loading';
import { cloudsearch } from '@/api/search';
import SongList from '@/components/playlist/songList';
export default {
    mixins: [loading],
    data() {
        return {
            trackIds:[],
            keywords:'',
        }
    },
    components:{
        SongList,
    },
    watch: {
        '$route.query.keywords':{
            handler(val,oldVal){
                if (val) {
                    this.$nextTick(() => {
                        this.load = this.loading('searchSongs')
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
            let res = await cloudsearch({keywords: this.keywords, type: 1});
            this.trackIds = []
            res.result.songs.map(item => {
                this.trackIds.push(item.id)
            })
            this.load.close()
        }
    },
}
</script>
<style lang="scss">
    
</style>