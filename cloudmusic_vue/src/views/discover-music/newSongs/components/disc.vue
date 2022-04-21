<template>
    <div class="disc">
        <div>
            <span v-for="item in discTypes"
            :class="{selected: item.value === area}"
            :key="item.value"
            @click="changeType(item.value)">
                {{item.content}}
            </span>
        </div>
        <div>
            <DiscBox style="margin:20px 0 0 0" :area="area"/>
        </div>
    </div>
</template>
<script>
import { discTypes } from '../data';
import DiscBox from './discBox';
export default {
    components:{
        DiscBox,
    },
    data() {
        return {
            discTypes,
            area: 'ALL',
        }
    },
    methods: {
        changeType(val) {
            this.area = val
        }
    },
}
</script>
<style scoped lang="scss">
.disc {
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