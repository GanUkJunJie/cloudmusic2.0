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
import { getLoveList } from '@/api/service';
export default {
    props:{
        id: [Number,String]
    },
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
    computed: {
        //歌单中歌曲的id
        trackIds() {
            const arr = []
            if (!this.playlist.trackIds) return;
            for (const iterator of this.playlist.trackIds) {
                arr.push(iterator.id || iterator)
            }
            return arr
        }
    },
    watch:{
        id:{
            handler(val,oldVal){
                if (val) {
                    this.getPlaylistDetail(val)
                }
            },
            immediate: true
        }
    },
    mounted() {
        this.getMyPlaylistDetail()
    },
    methods: {
        getPlaylistDetail(id){
            playlistDetail({
                id: id
            }).then(res => {
                this.playlist = res.playlist
            })
        },
        getMyPlaylistDetail(){
            if (this.$route.query.uuid) {
                getLoveList({
                    uuid: this.$route.query.uuid
                }).then(res => {
                    this.playlist = Object.assign({},res.result.playlist,{
                        name:'我喜欢的音乐',
                        creator:{
                            avatarUrl: res.result.playlist.avatarUrl,
                            nickname: res.result.playlist.nickname,
                        },
                        trackIds: res.result.trackIds,
                    })
                    
            })
            }
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