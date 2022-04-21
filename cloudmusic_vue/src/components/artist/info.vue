<template>
    <div class="info">
        <h2>{{ artist.name }}</h2>
        <span class="transNames">{{ artist.transNames? artist.transNames.toString():'' }}</span>
        <CloudButton leftIcon="icon-collection" text="收藏"/>  
        <div class="musicCount">
            <span>单曲数: {{ artist.musicSize }}</span>
            <span>专辑数: {{ artist.albumSize }}</span>
            <span>MV数: {{ artist.mvSize }}</span>
        </div>
    </div>
</template>
<script>
import CloudButton from '@/components/cloud-button';
export default {
    props:{
        artist: Object
    },
    components: {
        CloudButton,
    }
}
</script>
<style scoped lang="scss">
.info {
    margin-left: 20px;
    line-height: 35px;
    h2 {
        margin: 0;
    }
    .transNames {
        font-size: 12px;
    }
    .musicCount{
        font-size: 15px;
        span {
            margin-right: 20px;
        }
    }
}
</style>