<template>
    <div>
        <div 
            class="official"
            v-for="(item, index) in official" :key="index">
            <PictureBox @click="playlistDetail(item.id)" :src="item.coverImgUrl" :size="170"/>
            <Table class="table" :item="item" @playlistDetail="playlistDetail"/>
        </div>
    </div>
</template>
<script>
import PictureBox from '@/components/pictureBox';
import Table from './table';
export default {
    props:{
        official:{
            type: Array,
            default: []
        }
    },
    components: {
        PictureBox,
        Table,
    },
    methods: {
        //歌单详情页
        playlistDetail(id) {
            this.$router.push({
                name: 'playlistDetail',
                query: {
                    id:id,
                }
            })
        }
    },
}
</script>
<style scoped lang="scss">
.official {
    display: flex;
    margin-bottom: 30px;
    .table{
        margin-left: 30px;
        width: 820px;
    }
}
</style>