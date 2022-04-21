<template>
    <div class="tabs">
        <el-tabs v-model="activeName">
            <el-tab-pane label="创建的歌单" name="create">
                
            </el-tab-pane>
            <el-tab-pane label="收藏的歌单" name="collection">
                
            </el-tab-pane>
            <el-tab-pane label="创建的音乐专栏" name="column">
                
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
export default {
    data() {
        return {
            activeName: 'create',
        }
    },
}
</script>
<style lang="">
    
</style>