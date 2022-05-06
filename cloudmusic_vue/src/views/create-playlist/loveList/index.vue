<template>
    <div>
        <el-empty class="empty" description="快去添加你喜欢的音乐吧"></el-empty>
    </div>
</template>
<script>
import { getCount } from '@/api/service';
export default {
    mounted() {
        this.getLoveList()
    },
    computed: {
        uuid(){
            return this.$store.getters.user.uuid
        }
    },
    methods: {
        async getLoveList(){
            if (!this.uuid) {
                this.$noUserLogin()
                return
            }
            const count = await getCount({uuid: this.uuid})
            if (!count.result) return 
            this.$router.push({ 
                name: 'playlistDetail',
                query: {
                    uuid: this.uuid,
                }
            })
        }
    },
}
</script>
<style scoped lang="scss">
    .empty{
        height: 700px;
    }
</style>