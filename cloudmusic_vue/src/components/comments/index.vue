<template>
    <div class="comments">
        <div class="title">{{ title }}{{ total? '('+total+')': ''}}</div>
        <Comment v-for="(item, index) in comments" :key="index" :comment="item"/>
    </div>
</template>
<script>
import Comment from './comment';
export default {
    props:{
        title:{
            type: String,
            default: '全部评论'
        },
        comments: {
            type: Array,
            default: []
        },
        total: {
            type: Number,
            default: 0
        }
    },
    components:{
        Comment,
    }
}
</script>
<style scoped lang="scss">
.comments{
    margin: auto;
    width: 620px;
    .title{
        margin-top: 50px;
        font-size: 15px;
        font-weight: bold;
    }
}
</style>