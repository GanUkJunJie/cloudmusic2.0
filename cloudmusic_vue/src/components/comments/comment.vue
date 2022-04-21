<template>
    <div class="comment">
        <el-avatar :size="35" :src="avatarUrl"></el-avatar>
        <div class="content">
            <span class="name">{{ nickname }}：</span>
            <span>"{{ comment.content }}"</span>
            <div class="date">{{ comment.time | showData }}</div>
        </div>
    </div>
</template>
<script>
import { formatDate } from '@/utils/tools';
export default {
    props: {
        comment: Object
    },
    computed: {
        avatarUrl(){
            return this.comment?.user?.avatarUrl
        },
        nickname(){
            return this.comment?.user?.nickname
        }
    },
    filters: {
        showData: function (time) {
            let date = new Date(time)
            return formatDate(date, 'yyyy-MM-dd')
        }
    }
}
</script>
<style scoped lang="scss">
.comment {
    padding-top: 20px;
    min-height: 50px;
    display: flex;
    border-bottom: 1px solid #EAEAEA;
    .content{
        width: 550px;
        margin-left: 15px;
        font-size: 13px;
        .name {
            color: #507DAF;
        }
        .date {
            margin: 10px 0;
            font-size: 12px;
            color: #919191;
        }
    }
}
</style>