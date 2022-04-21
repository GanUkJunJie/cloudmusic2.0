<template>
    <div class="newSongs">
        <div class="nav">
            <div class="btn">
                <button @click="song" :class="{selected: songOrDisc}">新歌速递</button>
                <button @click="disc" :class="{selected: !songOrDisc}">新碟上架</button>
            </div>
        </div>
        <div>
            <Song v-if="songOrDisc"/>
            <Disc v-if="!songOrDisc"/>
        </div>
    </div>
</template>
<script>
import Song from './components/song';
import Disc from './components/disc';
export default {
    components: {
        Song,
        Disc,
    },
    data() {
        return {
            songOrDisc: true,
        }
    },
    methods: {
        song(){
            this.songOrDisc = true
        },
        disc(){
            this.songOrDisc = false
        }
    },
}
</script>
<style scoped lang="scss">
.nav{
    display: flex;
    margin-top: 20px;
    .btn{
        margin: auto;
        border-radius: 50px;
        border: 1px solid #BBBBBB;
        button{
            color: black;
            padding: 5px 30px;
            text-decoration: none;
            border: 0;
            border-radius: 50px;
            background-color: white;
            &:hover {
                background-color: #F4F4F4;
            }
        }
        .selected{
            background-color: #BBBBBB;
        }
    }
}

</style>