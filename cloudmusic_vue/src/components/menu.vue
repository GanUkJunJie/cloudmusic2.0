<template>
    <div>
        <el-menu
            :default-active="menu[activeMenu].path"
            router
            class="horizontalMenu"
            mode="horizontal">
            <el-menu-item 
                v-for="item in menu" :key="item.path" 
                :index="item.path">
                {{ item.name }}
            </el-menu-item>
        </el-menu>
        <keep-alive>
            <router-view/>
        </keep-alive>
    </div>
</template>
<script>
export default {
    props:{
        menu: Array,
        activeMenu:{
            type: Number,
            default: 0
        }
    },
}
</script>
<style scoped lang="scss">
.el-menu-item{
    padding: 0;
    margin-right: 40px;
    height: 50px;
    font-size: 15px;
    &.is-active {
        font-size: 15px;
    }
}
</style>