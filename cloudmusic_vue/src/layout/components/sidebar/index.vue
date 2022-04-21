<template>
    <div id="sidebar" class="sidebarItem">
        <el-scrollbar>
            <el-menu  :default-active="activeMenu" router>
                <sidebar-item
                    v-for="route in menu"
                    :key="route.path"
                    :item="route"
                />
            </el-menu>
        </el-scrollbar>
    </div>
</template>
<script>
import SidebarItem from './sidebarItem';
export default {
    components: { SidebarItem },
    computed: {
        menu(){
            return this.$store.getters.menu;
        },
        activeMenu(){
            return this.$route.meta.activeMenu
        }
    },
}
</script>
<style scoped lang="scss">
#sidebar{
    height: 670px;
    .el-scrollbar{
        height: 100%;
        
    }
    /deep/.el-scrollbar__bar{
        right: 0;
    }
}
</style>