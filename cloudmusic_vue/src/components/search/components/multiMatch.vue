<template>
    <div class="multiMatch">
        <div class="interested">你可能感兴趣</div>
        <div style="display:flex">
            <div class="matchBox" v-if="multiMatch.artist">
                <div class="content">
                    <div><el-avatar :size="45" :src="multiMatch.artist[0].img1v1Url"></el-avatar></div>
                    <div class="info">
                        <div>歌手：{{multiMatch.artist[0].name}}</div>
                        <div class="fans">
                            粉丝：{{multiMatch.artist[0].fansSize+'  '}}
                            歌曲：{{multiMatch.artist[0].musicSize}}
                        </div>
                    </div>
                </div>
            </div>
            <div class="matchBox" v-if="multiMatch.album">
                <div class="content">
                    <div><el-avatar :size="45" shape="square" :src="multiMatch.album[0].blurPicUrl"></el-avatar></div>
                    <div class="info">
                        <div>专辑：{{multiMatch.album[0].name}}</div>
                        <div class="fans">
                            {{getArtists(multiMatch.album[0].artists)}}
                        </div>
                    </div>
                </div>
            </div>
            <div class="matchBox" v-if="multiMatch.new_mlog">
                <div class="content">
                    <div><el-avatar :size="45" shape="square" style="width:80px"
                    :src="multiMatch.new_mlog[0].baseInfo.resource.mlogBaseData.coverUrl"></el-avatar></div>
                    <div class="info">
                        <div>视频：{{multiMatch.new_mlog[0].baseInfo.resource.mlogBaseData.text}}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import { multiMatchSearch } from '@/api/search';
export default {
    props: {
        keywords: String,
    },
    data() {
        return {
            multiMatch: {},
        }
    },
    watch: {
        keywords:{
            handler(val, oldVal){
                this.getMultiMatchSearch()
            },
            immediate:true
        }
    },
    methods: {
        getMultiMatchSearch(){
            multiMatchSearch({
                keywords: this.keywords
            }).then(res => {
                this.multiMatch = res.result
            })
        },
        getArtists(artists){
            return artists.map(item => {
                return item.name
            }).join(' ')
        },
    },
}
</script>
<style scoped lang="scss">
.multiMatch{
    .interested{
        margin-bottom: 10px;
        font-size: 12px;
        color: #676767;
    }
}
.matchBox{
    margin-right: 10px;
    display: flex;
    width: 300px;
    height: 70px;
    background-color: #F4F4F4;
    border-radius: 5px;
    .content{
        margin: auto 15px;
        display: flex;
        .info{
            margin-left: 10px;
            margin-top: 5px;
            font-size: 14px;
            .fans{
                color: #989898;
            }
        }
    }
}
</style>