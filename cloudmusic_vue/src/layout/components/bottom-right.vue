<template>
    <div class="right">
        <span class="quality">标准</span>
        <i class="iconfont icon-soundEffect"></i>
        <i class="iconfont icon-volume"></i>
        <i class="iconfont icon-share"></i>
        <i class="iconfont icon-playlist"></i>
    </div>
</template>
<script>
export default {
    
}
</script>
<style scoped lang="scss">
    .right {
        display: flex;
        justify-content: space-around;
        width: 220px;
        margin: auto;
        margin-left: 180px;
        i {
            font-size: 20px;
        }
        .quality {
            font-size: 12px;
            padding: 1px 3px;
            border: 1px solid;
            font-family: 'SimSun';
        }
    }
</style>