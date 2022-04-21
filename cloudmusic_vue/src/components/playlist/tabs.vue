<template>
    <div class="tabs">
        <el-tabs v-model="activeName">
            <el-tab-pane label="歌曲列表" name="song">
                <SongList v-bind="$attrs"/>
            </el-tab-pane>
            <el-tab-pane label="评论" name="comments">评论</el-tab-pane>
            <el-tab-pane label="收藏者" name="collectors">收藏者</el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
import SongList from './songList';
export default {
    components:{
        SongList,
    },
    data() {
        return {
            activeName: 'song',
        }
    },
}
</script>
<style scoped lang="scss">
/deep/.el-tabs__content{
    margin-left: -30px;
}
</style>