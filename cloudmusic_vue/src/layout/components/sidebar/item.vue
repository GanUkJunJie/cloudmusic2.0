<template>
    <div class="menu">
        <i v-if="icon" class="iconfont" :class="icon"/>
        <span>{{ title }}</span>
    </div>
</template>
<script>
export default {
    name: 'MenuItem',
    props: {
        icon: {
            type: String,
            default: ''
        },
        title: {
            type: String,
            default: ''
        }
    }
}
</script>
<style scoped lang="scss">
    .menu {
        overflow:hidden; 
        text-overflow:ellipsis;
        -webkit-box-orient:vertical;
        -webkit-line-clamp:1;
        word-wrap: break-word;
    }
</style>