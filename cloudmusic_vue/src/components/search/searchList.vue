<template>
    <div class="search">
        <el-popover
            placement="bottom"
            v-model="visible"
            title=""
            :visible-arrow="false"
            popper-class="popover"
            trigger="focus">
            <el-input slot="reference" placeholder="请输入内容" 
                v-model="searchInput" @keyup.enter.native="onSubmit"
                @input="inputSearch"
                prefix-icon="el-icon-search" size="mini">
            </el-input>
            <div v-if="!searchSuggestList.order">
                <div class="title">热搜榜</div>
                <div class="searchItem" :class="{topThree: index<3}" v-for="(item, index) in hotSearchList" :key="index"
                    @click="clickSearchItem(item.searchWord)">
                    <div class="index">{{ index+1 }}</div>
                    <div class="searchWord">
                        {{ item.searchWord }}
                        <span class="score">{{ item.score }}</span>
                        <div class="content hidden">{{ item.content}}</div>
                    </div>
                </div>
            </div>
            <div class="searchSuggest" else>
                <div class="searchSuggestItem"
                v-for="key in searchSuggestList.order" :key="key">
                    <div class="searchSuggestTitle">
                        <i class="iconfont" :class="searchSuggestTitle[key][0]"></i>
                        <span>{{ searchSuggestTitle[key][1] }}</span>
                    </div>
                    <div class="searchSuggestContent hidden" v-for="(item,index) in searchSuggestList[key]" :key="index"
                        @click="clickSearchItem(item.name)">
                        <span>{{item.name}}</span>
                        <span v-if="key === 'albums'">&nbsp;-&nbsp;{{item.artist.name}}</span>
                        <span v-if="key === 'songs'">&nbsp;-&nbsp;{{getArtists(item.artists)}}</span>
                    </div>
                </div>
            </div>
        </el-popover>
    </div>
</template>
<script>
import { hotSearch, searchSuggest } from '@/api/search';
export default {
    data() {
        const searchSuggestTitle = {
            'albums': ['icon-album', '专辑'],
            'artists': ['icon-singer', '歌手'],
            'playlists': ['icon-circle-order', '歌单'],
            'songs': ['icon-single', '单曲'],
        }
        return {
            visible: false,
            searchInput:'',
            hotSearchList: [],
            timer: '',
            searchSuggestTitle,
            searchSuggestList: {},
        }
    },
    mounted() {
        this.getHotSearch()
    },
    methods: {
        getHotSearch(){
            hotSearch().then(res => {
                this.hotSearchList = res.data
            })
        },
        onSubmit(e){
            if (e.keyCode == 13 && this.searchInput != "") {
                this.getSearchResult()
            }
        },
        inputSearch(){
            clearTimeout(this.timer);
            if (this.searchInput) {
                this.timer = setTimeout(() => {
                    this.getSearchSuggest()
                }, 500);
            } else {
                this.searchSuggestList =  {}
            }
        },
        getSearchSuggest(){
            searchSuggest({
                keywords: this.searchInput
            }).then(res => {
                this.searchSuggestList = res.result
            })
        },
        getArtists(artists){
            return artists.map(item => {
                return item.name
            }).join(' ')
        },
        clickSearchItem(searchWord){
            this.searchInput = searchWord
            this.getSearchResult()
        },
        getSearchResult(){
            this.visible = false
            this.$router.push({ 
                name: `searchSongs`,
                query: {
                    keywords:this.searchInput,
                }
            })
        }
    },
}
</script>
<style lang="scss">
.popover {
    overflow: scroll;
    width: 400px;
    height: 650px;
    margin-left: 60px;
    padding: 0 !important;
}
.title {
    color: #666666;
    font-size: 15px;
    padding: 12px 12px 0 12px;
}
.searchItem {
    display: flex;
    padding: 15px 0;
    &:hover {
        background-color: #F2F2F2;
    }
    .index {
        width: 20px;
        font-size: 17px;
        margin: 0 20px;
        color: #C2C2C2;
    }
    .searchWord {
        color: #333333;
        margin-right: 10px;
        .score {
            margin-left: 5px;
            font-weight: normal;
            color: #C2C2C2;
        }
        .content{
            font-weight: normal;
            font-size: 12px;
            color: #999999;
        }
    }
}
.topThree {
    .index {
        color: #EC4141;
    }
    .searchWord {
        font-weight: bold;
    }
}
.searchSuggest {
    .searchSuggestItem{
        .searchSuggestTitle{
            margin-left: 20px;
            padding: 15px 0;
            color: #999999;
            i {margin-right: 5px;}
        }
        .searchSuggestContent{
            &:hover{
                background-color: #F2F2F2;
            }
            font-size: 12px;
            color: #333333;
            padding: 0 40px;
            line-height: 40px;
            
        }
    }
}
.hidden {
    overflow:hidden; 
    text-overflow:ellipsis;
    display:-webkit-box;
    -webkit-box-orient:vertical;
    -webkit-line-clamp:1;
    word-wrap: break-word;
}
</style>