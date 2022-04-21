<template>
    <span class="describe lightBlackTag"> {{ describe }}</span>
</template>
<script>
export default {
    props:{
        describe: String,
    }
}
</script>
<style scoped lang="scss">
    .describe {
        margin-top: 10px;
        font-size: 14px;
        overflow:hidden; 
        text-overflow:ellipsis;
        display:-webkit-box;  //将对象作为弹性伸缩盒子模型显示。
        -webkit-box-orient:vertical; //从上到下垂直排列子元素（设置伸缩盒子的子元素排列方式）
        -webkit-line-clamp:2; //这个属性不是css的规范属性，需要组合上面两个属性，表示显示的行数。此处为2行
        word-wrap: break-word;//允许单词内断句，首先会尝试挪到下一行，看看下一行的宽度够不够，不够的话就进行单词内的断句
    }
</style>