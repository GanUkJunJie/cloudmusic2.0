<template>
    <div id="layout">
        <el-container>
            <el-header id="header">
                <AppHeader />
            </el-header>
            <el-container>
                <el-aside id="aside">
                    <Sidebar />
                </el-aside>
                <el-container>
                    <el-main id="main">
                        <!-- <TagsView /> -->
                        <AppMain />
                    </el-main>
                </el-container>
            </el-container>
            <el-footer id="footer"> <AppFooter /> </el-footer>
        </el-container>
        <MusicDetailCard/>
    </div>
</template>
<script>
import { AppHeader, Sidebar, TagsView, AppMain, AppFooter} from './components';
import MusicDetailCard from '@/components/musicCard/musicDetailCard';
export default {
    name: 'Layout',
    components: {
        AppHeader,
        Sidebar,
        TagsView,
        AppMain,
        AppFooter,
        MusicDetailCard,
    },
}
</script>
<style>
    
</style>