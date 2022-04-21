<template>
    <div class="table">
        <div class="nav">
            <CloudButton 
            @click.native="dialogVisible = !dialogVisible" 
            rightIcon="icon-right" 
            :text="tag" 
            :width="100"/>
            <div class="right" >
                <CloudButton
                    style="margin:0 3px"
                    v-for="(name, index) in hotTags" :key="index"
                    @click.native="changeTag(name)"
                    type="classButton" :selected="tag === name? 'redNow':''"  :text="name"/>
            </div>
        </div>
        <MusicBox :boxList="playlists"/>
        <AllTags 
        :dialogVisible="dialogVisible" 
        @dialogVisibleChange="dialogVisibleChange" 
        @changeTag="changeTag"/>
    </div>
</template>
<script>
import CloudButton from '@/components/cloud-button';
import MusicBox from '@/components/musicBox';
import AllTags from './allTags';
import { hotTags, hotPlaylist } from '@/api/discover-music/playlist';
export default {
    components:{
        CloudButton,
        MusicBox,
        AllTags,
    },
    data() {
        return {
            tag: '全部歌单',
            hotTags: '',
            playlists: [],
            dialogVisible: false,
        }
    },
    mounted() {
        this.getHotTags()
        this.getHotPlaylist(this.tag)
    },
    methods: {
        getHotTags(){
            hotTags().then(res => {
                this.hotTags = res.tags.map(item => item.name)
            })
        },
        changeTag(tag) {
            this.tag = tag
            this.getHotPlaylist()
        },
        getHotPlaylist(){
            hotPlaylist({
                cat: this.tag,
                limit: 10,
                offset: 0,
            }).then(res => {
                this.playlists = res.playlists
            })
        },
        dialogVisibleChange(val){
            this.dialogVisible = val
        }
    },
}
</script>
<style scoped lang="scss">
.table{
    margin-top: 20px;
    position: relative;
    .nav{
        position: relative;
        display: flex;
        .right {
            position: absolute;
            right: 0;
            display: flex;
            line-height: 25px;
        }
    }
}
</style>