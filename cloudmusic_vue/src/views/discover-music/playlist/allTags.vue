<template>
    <div v-if="dialogVisible" class="allTags">
        <div class="all" @click="changeTag('全部歌单')">{{catList.all && catList.all.name}}</div>
        <div 
            class="others"
            v-for="(categories, index) in catList && catList.categories" :key="index">
            <div class="categories">
                <i class="iconfont" :class="getIcon(index)"></i>
                <span>{{categories}}</span>
            </div>
            <div>
                <el-row class="sub">
                    <el-col :span="4"
                        v-for="(sub, indexCol) in subs[index]" :key="indexCol">
                        <CloudButton
                        @click.native="changeTag(sub.name)"
                        type="classButton" :selected="tag === sub.name? 'redNow':''" :text="sub.name"
                        :mark="sub.hot"/>
                    </el-col>
                </el-row>
            </div>
            
        </div>
    </div>
</template>
<script>
import { tags } from '@/api/discover-music/playlist';
import CloudButton from '@/components/cloud-button';
export default {
    props: {
        dialogVisible: Boolean,
    },
    components:{
        CloudButton,
    },
    data() {
        return {
            catList: {},
            tag: '',
        }
    },
    computed: {
        subs(){
            if (this.catList && this.catList.sub) {
                let arr = [[],[],[],[],[]]
                this.catList.sub.forEach(item => {
                    switch(item.category){
                        case 0: arr[0].push(item);break;
                        case 1: arr[1].push(item);break;
                        case 2: arr[2].push(item);break;
                        case 3: arr[3].push(item);break;
                        case 4: arr[4].push(item);break;
                    }
                })
                return arr
            }
        }
    },
    mounted() {
        this.getTags()
    },
    methods: {
        getTags(){
            tags().then(res => {
                this.catList = res
            })
        },
        getIcon(index){
            const icon = ['icon-languages','icon-Piano',
            'icon-scene','icon-emotion','icon-theme']
            return icon[index]
        },
        getTag(index){
            if (this.catList && this.catList.sub) {
                return this.catList.sub.filter(item => {
                    return item.category == index
                })
            }
        },
        changeTag(tag){
            this.tag = tag
            this.getHotPlaylist()
        },
        getHotPlaylist(){
            this.$emit('dialogVisibleChange',false)
            this.$emit('changeTag',this.tag)
        }
    },
}
</script>
<style scoped lang="scss">
.allTags {
    position: absolute;
    top: 40px;
    width: 740px;
    background-color: white;
    border-radius: 10px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.2);
    z-index: 2;
    .all {
        padding-left: 30px;
        height: 55px;
        line-height: 55px;
        border-bottom: 1px solid #ccc;
        &:hover {
            color: #FD544E;
        }
    }
    .others {
        display: flex;
        padding: 20px;
        line-height: 40px;
        .categories {
            color: #999999;
            width: 140px;
            font-size: 15px;
            span { vertical-align: middle;}
            i {
                vertical-align: middle;
                font-size: 25px;
                margin-right: 5px;
            }
        }
        .sub {
            width: 600px;
        }
    }
    
}
</style>