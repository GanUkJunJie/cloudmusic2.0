export default {
    data() {
        return {
            load:'',
        }
    },
    methods: {
        loading(ref){
            return this.$loading({
                // lock: true,
                text: '加载中',
                spinner: 'el-icon-loading',
                background: 'white',
                target: this.$refs[ref]
            })
        }
    },
}