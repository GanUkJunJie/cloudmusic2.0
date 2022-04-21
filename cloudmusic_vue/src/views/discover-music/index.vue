<template>
    <div>
        <el-menu
            :default-active="$route.path"
            router
            class="topMenu horizontalMenu marginLeft"
            mode="horizontal">
            <el-menu-item index="/discoverMusic/personality">个性推荐</el-menu-item>
            <el-menu-item index="/discoverMusic/custom">专属定制</el-menu-item>
            <el-menu-item index="/discoverMusic/playlist">歌单</el-menu-item>
            <el-menu-item index="/discoverMusic/rank">排行榜</el-menu-item>
            <el-menu-item index="/discoverMusic/singer">歌手</el-menu-item>
            <el-menu-item index="/discoverMusic/newSongs">最新音乐</el-menu-item>
        </el-menu>
        <keep-alive>
            <router-view/>
        </keep-alive>
        
    </div>
</template>
<script>
export default {
    name:'discover-music'
}
</script>
<style scoped lang="scss">
.marginLeft{
    margin-left: -20px;
}
</style>