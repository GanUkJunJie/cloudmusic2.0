<template>
    <div>
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
<style>
    
</style>