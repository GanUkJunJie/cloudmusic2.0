<template>
    <div class="searchResult">
        <p >搜索{{' '+keywords}}</p>
        <MultiMatch style="margin-bottom:20px" :keywords="keywords"/>
        <Menu :menu="menu"/>
    </div>
</template>
<script>
import MultiMatch from './components/multiMatch';
import Menu from '@/components/menu';
import SongList from '@/components/playlist/songList';
export default {
    components:{
        MultiMatch,
        SongList,
        Menu,
    },
    computed: {
        keywords(){
            return this.$route.query.keywords
        },
        menu(){
            return [
                {path:`/search/searchSongs?keywords=${this.keywords}`, name:'单曲'},
                {path:`/search/searchArtists?keywords=${this.keywords}`, name:'歌手'},
                {path:`/search/searchAlbums?keywords=${this.keywords}`, name:'专辑'},
                {path:`/search/searchPlaylist?keywords=${this.keywords}`, name:'歌单'},
            ]
        }
    },
}
</script>
<style scoped lang="scss">
.searchResult{
    p {
        font-weight: bold;
        font-size: 20px;
    }
}
</style>