<template>
    <div class="song">
        <div>
            <span v-for="item in songTypes"
            :class="{selected: item.value === type}"
            :key="item.value"
            @click="changeType(item.value)">
                {{item.content}}
            </span>
        </div>
        <div>
            <Table style="margin:20px 0 0 -30px" :type="type"/>
        </div>
    </div>
</template>
<script>
import { songTypes } from '../data';
import Table from './table';
export default {
    components:{
        Table,
    },
    data() {
        return {
            songTypes,
            type: 0,
        }
    },
    methods: {
        changeType(val) {
            this.type = val
        }
    },
}
</script>
<style scoped lang="scss">
.song {
    span {
        color: #676767;
        font-size: 14px;
        margin-right: 25px;
        &:hover {
            color: #000000;
        }
    }
    .selected {
        font-weight: bold;
        color: #000000;
    }
}
</style>