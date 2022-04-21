<template>
    <div class="marginTop">
        <div class="artistTitle">
            <PictureBox :src="artist.cover" :size="180"/>
            <Info :artist="artist"/>
        </div>
        <Tabs :id="artist.id" :name="artist.name"/> 
    </div>
</template>
<script>
import PictureBox from '@/components/pictureBox';
import Info from './info';
import Tabs from './tabs';
import { artistDetail } from '@/api/discover-music/singer'
export default {
    components: {
        PictureBox,
        Info,
        Tabs,
    },
    data() {
        return {
            artist: {}
        }
    },
    mounted() {
        this.getArtistDetail()
    },
    methods: {
        getArtistDetail(){
            artistDetail({
                id: this.$route.query.id
            }).then(res => {
                this.artist = res.data.artist
            })
        }
    },
}
</script>
<style scoped lang="scss">
.artistTitle {
    display: flex;
    margin-bottom: 30px;
}
</style>