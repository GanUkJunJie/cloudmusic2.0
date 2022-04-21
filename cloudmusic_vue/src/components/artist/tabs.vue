<template>
    <div class="tabs">
        <el-tabs v-model="activeName">
            <el-tab-pane label="专辑" name="album">
                <Album v-bind="$attrs"/>
            </el-tab-pane>
            <el-tab-pane label="MV" name="mv"></el-tab-pane>
            <el-tab-pane label="歌手详情" name="detail">
                <Detail v-bind="$attrs"/>
            </el-tab-pane>
            <el-tab-pane label="相似歌手" name="similar">
                <Similar v-bind="$attrs"/>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
import Album from './components/album';
import Detail from './components/detail';
import Similar from './components/similar';
export default {
    components:{
        Album,
        Detail,
        Similar,
    },
    data() {
        return {
            activeName: 'album',
        }
    },
}
</script>
<style scoped lang="scss">
</style>