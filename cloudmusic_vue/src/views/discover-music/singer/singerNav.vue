<template>
    <div>
        <div class="singerNav"
        v-for="(val, key) in menu" :key="key">
            <div class="key"> {{ menuMean[key] }}： </div>
            <div>
                <el-row class="item">
                    <el-col :span="2"
                    v-for="item in val" :key="item.value">
                        <CloudButton
                            @click.native="changeTag(key,item.value)"
                            type="classButton"  :text="item.content"
                            :selected="tag[key] === item.value? 'redNow':''"/>
                    </el-col>
                </el-row>
            </div>
        </div>
    </div>
</template>
<script>
import { menuMean, menu } from '@/common/singer';
import CloudButton from '@/components/cloud-button';
export default {
    components: {
        CloudButton,
    },
    data() {
        return {
            menuMean,
            menu,
            tag:{
                area: -1,
                type: -1,
                initial: -1,
            }
        }
    },
    methods: {
        changeTag(key,value){
            this.tag[key] = value
            this.$emit('changeTag',this.tag)
        },
    },
}
</script>
<style scoped lang="scss">
.singerNav{
    display: flex;
    .key {
        font-size: 12px;
        color: #373737;
        line-height: 24px;
        margin-right: 15px;
    }
    .item {
        width: 950px;
    }
}
</style>