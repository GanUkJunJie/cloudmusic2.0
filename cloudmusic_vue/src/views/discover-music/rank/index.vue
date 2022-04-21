<template>
    <div class="rank">
        <p>官方榜</p>
        <Official :official="official"/>
        <p>全球榜</p>
        <MusicBox :boxList="TheGlobal"/>
    </div>
</template>
<script>
import Official from './official';
import MusicBox from '@/components/musicBox';
import { rankList } from '@/api/discover-music/rank'

export default {
    components: {Official, MusicBox},
    data() {
        return {
            official: [],
            TheGlobal: [],
        }
    },
    mounted() {
        this.getRankList()
    },
    methods: {
        getRankList(){
            rankList().then(res => {
                const arr = res.list
                if (arr.length > 4) {
                    this.official = res.list.splice(0, 4)
                    this.TheGlobal = arr
                } else {
                    this.official = arr
                    this.TheGlobal = []
                }
                
            }
        )
        }
    },
}
</script>
<style scoped lang="scss">
.rank {
    p {
        font-size: 20px;
        font-weight: 1000;
    }
}
</style>