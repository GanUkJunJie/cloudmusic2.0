<template>
    <div class="button">
        <button 
            :class="[type,selected]" 
            :style="buttonStyle">
            <div v-if="mark" class="hotMark">HOT</div>
            <i class="iconfont" :class="leftIcon"></i>
            <span>{{ text }}</span>
            <i class="iconfont" :class="rightIcon"></i>
        </button>
    </div>
</template>
<script>
export default {
    props:{
        //按钮类型
        type:{
            type: String,
            default: 'whiteButton'
        },
        //选中效果
        selected: String,
        //左边icon
        leftIcon:{
            type: String,
            default: ''
        },
        //文本
        text:{
            type: String,
            default: ''
        },
        //右边icon
        rightIcon:{
            type: String,
            default: ''
        },
        width: Number,
        mark:{
            type: Boolean,
            default: false
        },
    },
    computed: {
        buttonStyle(){
            if (this.width) {
                return {
                    width: this.width + 'px'
                }
            }
        },
    },
}
</script>
<style scoped lang="scss">
.button {
    button{
        position: relative;
    }
    .hotMark{
        position: absolute;
        top: -3px;
        right: -3px;
        width: 10px;
        height: 10px;
        color: #EC4141;
        font-size: 12px;
        font-weight: bold;
        transform: scale(0.5);
    }
    .whiteButton {
        height: 30px;
        color: #373737;
        background-color: #FFFFFF;
        border: 1px solid #D8D8D8;
        border-radius: 20px;
        &:hover {
            background-color: #F2F2F2;
        }
        span {
            padding: 0 5px;
        }
    }
    .redButton {
        height: 30px;
        color: #FFFFFF;
        background-color: #EC4141;
        border: 0;
        border-radius: 20px;
        &:hover {
            background-color: #CC3232;
        }
        span {
            padding: 0 5px;
        }
    }
    .yellowButton {
        height: 30px;
        color: #E7AA5A;
        border: 1px solid #E7AA5A;
        background-color: transparent;
        border-radius: 20px;
        &:hover {
            background-color: transparent;
        }
        span {
            padding: 0 5px;
        }
    }
    .classButton {
        font-size: 12px;
        border: 0;
        border-radius: 20px;
        color: #676767;
        background-color: transparent;
        &:hover {
            color: #000000;
        }
    }
    .redNow {
        background-color: #FDF5F5 !important;
        color: #EC4141 !important;
    }
}
</style>