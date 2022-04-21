<template>
    <div class="pictureBox" :style="boxStyle">
        <img class="imgBox" :src="src" @load="loaded">
        <el-skeleton class="skeleton" animated :loading="loading">
            <template slot="template">
                <el-skeleton-item variant="image" :style="boxStyle"></el-skeleton-item>
            </template>
        </el-skeleton>
    </div>
</template>
<script>
export default {
    props:{
        src: String,
        size: {
            type: Number,
            default: 190,
        },
    },
    data() {
        return {
            loading: true,
        }
    },
    computed: {
        boxStyle() {
            return `width:${this.size}px;height:${this.size}px;
            position: relative;border-radius: 10px;`
        }
    },
    methods: {
        //图片加载完成才显示
        loaded(){
            this.loading = false //加载完成
        },
    },
}
</script>
<style scoped lang="scss">
.skeleton{
    position: absolute;
    top: 0;
    left: 0;
    z-index: 999;
}
.imgBox {
    width: 100%;
    height: 100%;
    border-radius: 10px;
}
</style>