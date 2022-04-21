<template>
    <div>
        <!-- 二级导航 -->
        <el-submenu
            v-if="hasChildren && item.meta.isMenu"
            ref="submenu"
            :index="resolvePath(item.path)"
            class="levelTwo"
            :class="{keepOpen:item.meta.keepOpen}">
            <template slot="title">
                <item v-if="item.meta"
                    :icon = "item.meta.icon"
                    :title = "item.meta.title"/>
            </template>
            <sidebar-item
                v-for="child in item.children"
                :key="child.path"
                :item="child"
                :basePath="item.path"
            />
        </el-submenu>

        <!-- 一级导航 -->
        <el-menu-item
        v-else-if="item.meta.isMenu"
        @click="addTagsView"
        :index = "resolvePath(item.path)">
            <item v-if="item.meta"
                class="button"
                :icon="item.meta.icon"
                :title="item.meta.title" />
        </el-menu-item>
    </div>
</template>
<script>
import path from 'path';
import Item from './item';
export default {
    name: 'SidebarItem',
    components: { Item },
    props: {
        item: {
            type: Object,
            required: true
        },
        basePath: String
    },
    computed: {
        hasChildren(){
            return this.item.meta.hasChildren
        },
    },
    methods: {
        resolvePath(routePath){
            if (this.basePath) {
                return path.resolve(this.basePath,routePath)
            }
            return routePath
        },
        addTagsView(){
            this.$store.dispatch('tagsView/addTagsView', this.item)
        }
    },
}
</script>
<style scoped lang="scss">
</style>