<template>
    <div class="playlist marginTop">
        <div class="playlistTitle">
            <PictureBox :src="playlist.coverImgUrl" :size="180"/>
            <Info :playlist="playlist"/>
        </div>
        <Tabs :trackIds="trackIds"/>
    </div>
</template>
<script>
import PictureBox from '@/components/pictureBox';
import Info from './info';
import Tabs from './tabs';
import { playlistDetail } from '@/api/discover-music/playlist';
export default {
    components: {
        PictureBox,
        Info,
        Tabs,
    },
    data() {
        return {
            playlist: {},
        }
    },
    mounted() {
        this.getPlaylistDetail()
    },
    computed: {
        //歌单中歌曲的id
        trackIds() {
            const arr = []
            if (!this.playlist.trackIds) return;
            for (const iterator of this.playlist.trackIds) {
                arr.push(iterator.id)
            }
            return arr
        }
    },
    methods: {
        getPlaylistDetail(){
            playlistDetail({
                id: this.$route.query.id
            }).then(res => {
                this.playlist = res.playlist
            })
        }
    },
}
</script>
<style scoped lang="scss">
    .playlistTitle {
        display: flex;
        margin-bottom: 30px;
    }
</style>