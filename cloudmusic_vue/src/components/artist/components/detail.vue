<template>
    <div class="detail">
    <p>{{name}}简介</p>
    <div class="intro">{{introduce.briefDesc}}</div>
        <div class="introduce" v-for="(item, index) in introduce.introduction" :key="index">
        <p>{{item.ti}}</p>
        <div class="intro pre"
            v-for="(text, textIndex) in getText(item.txt)"
            :key="textIndex">
            {{text}}
        </div>
        </div>
    </div>
</template>
<script>
import { introduce } from '@/api/discover-music/singer';
export default {
    props:{
        id:{
            type: Number
        },
        name: String
    },
    data() {
        return {
            introduce: {},
        }
    },
    watch: {
        id:{
            handler(val,oldVal){
                if (val) {
                    this.getIntroduce()
                }
            },
        }
    },
    methods: {
        getIntroduce(){
            introduce({
                id: this.id
            }).then(res => {
                this.introduce = res
            })
        },
        getText(texts) {
            return texts.split('\n')
        }
    },
}
</script>
<style scoped lang="scss">
.detail {
    p {
        font-size: 15px;
        font-weight: bold;
    }
    .intro{
        text-indent: 2em;
        color: rgb(103, 103, 103);
        line-height: 40px;
        font-size: 15px;
    }
    .introduce {
        margin: 25px 0;
        .pre {
            /* 识别 \n */
            white-space: pre-line;
        }
    }
}

</style>