<template>
    <div>
        <MusicBox
        type="artists"
        :boxList="artists" 
        :showPlayCount="false"/>
    </div>
</template>
<script>
import MusicBox from '@/components/musicBox';
import { similar } from '@/api/discover-music/singer';
export default {
    props:{
        id:{
            type: Number
        },
        name: String
    },
    components:{
        MusicBox,
    },
    data() {
        return {
            artists: [],
        }
    },
    watch: {
        id:{
            handler(val,oldVal){
                if (val) {
                    this.getSimilar()
                }
            },
        }
    },
    methods: {
        getSimilar(){
            similar({
                id: this.id
            }).then(res => {
                this.artists = res.artists
            })
        }
    },
}
</script>
<style scoped lang="scss">
    
</style>