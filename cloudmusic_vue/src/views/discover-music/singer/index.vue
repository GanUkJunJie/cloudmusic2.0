<template>
    <div>
        <SingerNav style="margin:10px 0" @changeTag="changeTag"/>
        <MusicBox
        type="artists"
        :boxList="artists" 
        :showPlayCount="false"
        :size="150"/>
    </div>
</template>
<script>
import SingerNav from './singerNav';
import MusicBox from '@/components/musicBox';
import { artists } from '@/api/discover-music/singer'
export default {
    components: {
        SingerNav,
        MusicBox,
    },
    data() {
        return {
            area: -1,
            type: -1,
            initial: -1,
            limit: 12,
            offset: 0,
            artists: [],
        }
    },
    mounted() {
        this.getArtists()
    },
    methods: {
        changeTag(tag){
            this.area = tag.area
            this.type = tag.type
            this.initial = tag.initial
            this.getArtists()
        },
        getArtists(){
            artists({
                area: this.area,
                type: this.type,
                initial: this.initial,
                limit: this.limit,
                offset: this.offset,
            }).then(res => {
                this.artists = res.artists
            })
        }
    },
}
</script>
<style lang="">
    
</style>